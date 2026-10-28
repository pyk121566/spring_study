package com.hexagon.springmvc.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexagon.springmvc.common.web.Pager;
import com.hexagon.springmvc.domain.Emp;
import com.hexagon.springmvc.dto.request.EmpRequestDTO;
import com.hexagon.springmvc.exception.BusinessException;
import com.hexagon.springmvc.service.EmpService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//사원에 대한 요청을 처리하는 컨트롤러는 맞으나, 클라이언트의 비동기 요청을 받기 위한 컨트롤러임
//따라서 이 컨트롤러의 메서드들은 jsp 를 반환하면 안되고, 순수한 데이터만을 반환해서 응답 body 로 보내야 한다.
@RestController	//Rest 전용 컨트롤러라는 컨트롤러의 메서드에 이미 @ResponseBody 가 적용된 상태이다.
						//따라서 모든 이 클래스안의 메서드의 return 값을 jsp로 매핑하려고 하지 않고 , 데이터 자체를 응답 정보로 보내버린다.
//@RequestMapping("/rest/emps")
@Slf4j
@RequiredArgsConstructor
public class RestEmpController {
	
	private final EmpService empService;
	private final Pager pager;
	
	/*---------------------------------------------
	 * 사원 등록 요청 받기
	 ------------------------------------------------*/
	@PostMapping("/rest/emps")
	//@ResponseBody //이 어노테이션을 붙이면 DispatcherServlet 은 더이상 ViewResolver 에게 Jsp 와의 매핑을 시도하지 않는다.
							//그냥 응답 정보인 response 에 아래의 return 된 데이터를 탑재하고, tomcat 은 이 데이터를 전송해버림
							//단 , html 형식으로 보내지 않음...
	
	public String regist(EmpRequestDTO empRequestDTO) {
		log.debug("사원명은 {}", empRequestDTO.getName());
		log.debug("나이는 {}", empRequestDTO.getAge());
		log.debug("이메일은 {}", empRequestDTO.getEmail());
		log.debug("시장은 {}", empRequestDTO.getHeight());
		log.debug("몸무게는 {}", empRequestDTO.getWeight());
		log.debug("혈액형은 {}", empRequestDTO.getBloodType());
		
		empService.regist(empRequestDTO);
		
		return "ok";
	}

	/*----------------------------------
	 *  사원 목록 요청 받기
	  ---------------------------------*/
	@GetMapping("/rest/emps")
	//@ResponseBody
	public List getList() {
		List empList = empService.getEmpList(pager);
		
		
		//과일 3개를 모아서 바나나, 포도, 멜론
		/*
		 웹상으로 클라이언트와 서버가 데이터를 주고 받을 때는 문자열로만 주고 받을 수 있다.
		 따라서 개발자가 클라이언트에게 어떤 형식으로 데이터를 보낼지는 개발자 마음이다.
		 하지만, 개발시 어떤 기준이 없다면 , 회사간 , 회사 내에서 팀원간 의사소통에 문제가 발생한다.
		 따라서 전산 분야에서는 특히 웹상에서 문자열 데이터를 주고 받을 때 가장 많이 사용하는 형식이 있다
		 XML
		 JavaSript Opject Notatin (압도적) - JavaScript 의 객체 표기법
		  												- JOSN 이란 js의 객체 리터럴 형식을 그대로 본뜬 문자열을 의미
		 */
		//jackson 라이브러리를 이용하면, java와 JSON 문자열과의 변환을 자동으로 해결
		/*sb.append("{");
		sb.append("   \" name\":\"뽀삐\",");
		sb.append("    \"age\": 2,");
		sb.append("    \"gender\":\"girl\",");
		sb.append("    \"isPure\" : true, ");
		sb.append("    \"foods\":[\"로얄캐닌\", \"츄릅\", \"아이스크림\"],");
		sb.append("    \"friend\":{");
		sb.append("        \"name\":\"meo\",");
		sb.append("        \"age\":1");
		sb.append("    }");
		sb.append("}");
		*/
		return empList;
	}
	/*--------------------------------------
	 * 사원 상세 요청 받기
	 ----------------------------------------*/
	@GetMapping("/rest/emps/{empId}")
	public Emp getDetail(@PathVariable("empId") int empId) {
		return empService.getDetail(empId);
	}
	
	
	/*--------------------------------------
	 * 사원 1명 수정하기
	 ----------------------------------------*/
	@PutMapping("/rest/emps/{empId}")
	//@RequestBody 클라이언트가 전송한 파라미터가 json 형식일때 자동매핑을 위한 어노테이션
	public String update(@RequestBody EmpRequestDTO empRequestDTO) {
		log.debug("넘어온 사원명은 {}", empRequestDTO.getName());
		log.debug("넘어온 empId {}", empRequestDTO.getEmpId());
		
		return null;
	}
	
	
	//모델 영역에서 에러가 발생하면 이 컨트롤러까지 전달되기 때문에, 컨트롤러 영역에서 
	//적절한 예외를 처리하자!!
	//문법 또는 시스템 적인 에러 말고 우리가 사업상 정해놓은 규칙으로 정의한 커스텀 예외를 
	//비즈니스 예외라고 하고, 우리의 경우 클래스명을 BusinessException 으로 정했다..
	@ExceptionHandler(BusinessException.class)
	//@ResponseBody
	public String handle(BusinessException e) {
		
		return e.getMessage(); 	//클라이언트가 비동기 요청을 시도하면 에러 조차도 jsp 가 아닌
											//순수 데이터로 보여줘야 한다...
	}
	
	@ExceptionHandler(Exception.class)
	//@ResponseBody
	public String handle(Exception e) {
		return e.getMessage();
	}
}
