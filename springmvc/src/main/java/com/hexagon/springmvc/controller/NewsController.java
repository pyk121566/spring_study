package com.hexagon.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	/*
	 	비동기 방식으로 요청을 시도할 때는 요청 url 을 Restful 하게 해야하지만,
	 	실제 jsp 파일명을 주고받는 동기방식의 요청은 그럴필요없다
	 */
	@GetMapping("/main")
	public String getMain() {
		
		return "news/index";
	}
}
