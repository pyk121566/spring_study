package com.hexagon.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//이 클래스는 개발자가 직접 new 하지 않고, 스프링에게 빈으로 등록한다!!
//또한 이 클래스는 빈들 중 스프링의 컴포넌트라고 불리는 빈 중 하나이므로, 아래와 같은 어노테이션을 사용해야 한다..
/*
  스프링의 빈들 중 그 역할이 이미 정해져있는 빈을 가리켜 스프링의 컴포넌트라 하는데, 
  1) 하위 컨트롤러 역할을 수행하는 빈 : @Controller, @RestController
  2) DAO 역할을 수행하는 빈 : @Repository
  3) Service 역할을 수행하는 빈 : @Service
  4) 위 3영역의 외에 특수 컴포넌트 : @Component
 */
@RestController
public class TestController {
	
	//URL 에서 유저가 접근한 주소 매핑
	@GetMapping("/hi")
	public String getView() {
		
		return "my spring first result";
	}
	
}