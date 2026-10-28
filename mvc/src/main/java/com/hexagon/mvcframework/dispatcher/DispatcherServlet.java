package com.hexagon.mvcframe.dispatcher;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hexagon.mvcframework.handler.RequestMappingHandlerMapping;

import lombok.extern.slf4j.Slf4j;

/*
애플리케이션의 모든 요청을 받는 진입점 
  1. 요청을 받는다
  2. 요청을 분석한다(이 요청을 누가 처리할지를 결정짓고 해당 컨트롤러의 메서드 호출)
  5. 결과를 보여준다 
 */
@Slf4j
public class DispatcherServlet extends HttpServlet{
	RequestMappingHandlerMapping handlerMapping;
	
	//이 서블릿이 생성된 직후, 초기화를 위해 호출
	public void init(ServletConfig config) throws ServletException {
		ServletContext application = config.getServletContext();	//현재 애플리케이션에 대한 정보를 가진 전역 객체인 ServletContext 를 얻는다
		String contextConfigLocation = config.getInitParameter("contextConfigLocation");
		String realPath = application.getRealPath(contextConfigLocation);
		log.debug("매핑 파일의 OS상 실제 경로는 {}", realPath);
		
		handlerMapping = new RequestMappingHandlerMapping(realPath);
	}
	
	//서블릿의 생명주기 메서드(init, service, destory)중 요청을 처리하는 메서드인 service를 재정의한다!
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청받았어");

		//2단계 - 요청 분석 (직접하지 않고 RequestMappingHandlerMapping 에게 분석을 맡김)
		String uri = request.getRequestURI();	//웹브라우저가 요청한 요청 주소 ex) /board/list, /board/regist  등등..
		Controller controller = handlerMapping.getController(uri);	
		
		//우리 프레임웍의 경우 모든 요청을 다 닫는다고 선언되어 있으므로 (web.xml의 서블릿 매핑), 심지어 favicon 요청까지 받아버린다..favicon요청을 처리하는 컨트롤러를 따로 정의한 적이 없기 때문에
		//favicon 요청의 경우 controller 는 생성된 것이 없으므로 null 이다, 따라서 null 일떄는 Controller 의 매서드인 execute() 호출하지말자!! (NullPointerException 방지)
		if(controller ==null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		controller.execute(request, response);
	}
}
