package com.hexagon.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.hexagon.myapp.dto.request.NewsRequest;

//우리가 만든 프레임웍에서는 글쓰기, 글수정, 글삭제, 글상세, 목록 요청에 각각 1:1 대응하는 컨트롤러 클래스를 정의하였지만
//Spring 에서는 각각의 요청은 클래스가 아닌 매서드로 처리하는 방법을 지원해준다!!
@Controller
public class NewsController {

	//글쓰기 폼 요청
	@GetMapping("/news/registform")
	public View getForm() {
		return new InternalResourceView("/WEB-INF/views/news/write.jsp");
	}
	
	//글쓰기 요청 POST
	@PostMapping("/news/regist")
	public View regist(NewsRequest newsRequest) {
		//html의 파라미터명(name)과 DTO 의 멤버변수명이 일치할 경우, 컨트롤러의 메서드의 매개변수에 대입된 DTO 에는 HTML 파라미터가 자동으로 채워진다!!
		
		System.out.println("title is " + newsRequest.getTitle());
		System.out.println("writer is " + newsRequest.getWriter());
		System.out.println("content is " + newsRequest.getContent());
		//작성자, 제목, 내용...
		
		return null;
	}
	
	//글목록 요청 GET
	//형님 컨트롤러인 DispatcherServlet 에게 String을 반환하면, 이 String을 ViewResolver 에게 형님이 맡김
	//ViewResolver 는 접두어, 접미어를 조합하여 완전한 경로를 갖춘 View 를 형님에게 반환. 이때 View를 넘겨받은 형님은
	//View 의 render() 메서드를 호출하여 응답정보를 response 객체의 out에 저장
	@GetMapping("/news/list")
	public String getList() {
		System.out.println("글목록");
		return "news/list";
	}
	
	//글상세 요청 GET
	@GetMapping("/news/content")
	public View getContent() {
		System.out.println("글상세");
		return null;
	}
	
	//글삭제 요청 POST, GET
	@PostMapping("/news/delete")
	public View delete() {
		System.out.println("글삭제");
		return null;
	}
	
	//글수정 요청 POST
	@PostMapping("/news/update")
	public View update() {
		System.out.println("글수정");
		return null;
	}
}
