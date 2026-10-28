package com.study.booklog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.booklog.config.AppConfig;
import com.study.booklog.config.RootConfig;
import com.study.booklog.dto.BookDTO;

@Controller
public class BookController {
	private final AppConfig appConfig;
	private final RootConfig rootConfig;

	BookController(RootConfig rootConfig, AppConfig appConfig) {
		this.rootConfig = rootConfig;
		this.appConfig = appConfig;
	}

	//목록을 보여주는 메서드
	@GetMapping("/books")
	public String list(Model model) {

		model.addAttribute("message","Spring MVC Model 테스트!");
		
		return "book/list";
	}
	
	//등록화면을 보여주는 메서드
	@GetMapping("/books/regist")
	public String registForm() {
		return "book/regist";
	}
	
	//등록 메서드
	@PostMapping("/books/regist")
	public String regist(@ModelAttribute BookDTO bookDTO) {
		
		System.out.println("책 제목: " + bookDTO.getTitle());
		System.out.println("저자: " + bookDTO.getAuthor());
		System.out.println("장르: " +bookDTO.getGenre());
		
		return "redirect:/books";
	}	
}
