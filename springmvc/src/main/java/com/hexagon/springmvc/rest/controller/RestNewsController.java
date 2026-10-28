package com.hexagon.springmvc.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hexagon.springmvc.dto.request.NewsRequestDTO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RestNewsController {
	
	/*---------------------------------------------------------
	  HTTP 응답 정보를 제대로 처리해야 유지보수가 쉽다.
	  
	  [HTTP 응답의 3요소]
	1) HTTP status 코드 (200,500,404)
	2) 응답헤더
	3) 응답바디
	
	ResponseEntity 는? HTTP 응답 정보를 세부적으로, 체계적으로 구성할 수 있는 스프링 지원 객체
	----------------------------------------------------------- */
	
	@GetMapping("/api/news")
	public  ResponseEntity<List<String>> getList(HttpServletResponse response) {
		
		//헤더에 status 코드를 일부러 에러를 만들어서 보내기!! fetch 가 어떻게 동작하는지 보려고
		//response.setStatus(HttpServletResponse.SC_CONFLICT);
		
		//아직 db 연동을 안했으므로 , 게시물 목록을 가짜로 흉내 . Mock 데이터 만들어 보기
		List<String> newsList = new ArrayList<>(List.of(
				"강남에 큰 불",
				"태풍 큰거 온다",
				"일본 PHP 난리 부르스"
		));
		
		return ResponseEntity.status(HttpStatus.OK).body(newsList);
	}
	
	/*-------------------------------------------------------------------------------------------
	 	뉴스 등록 요청
	 	도메인을 이용하여 브라우저에서 전송된 파라미터를 받아도 되지만,
	 	이럴경우 HTML 파라미터명이 db 상의 컬럼명과 동일하게 되므로, 
	 	보안상 좋지 못하다. 
	 	@RequestBOdy : 클라이언트가 전송한 데이터 형식이 form 데이터가 아닌 
	 							  JSON 문자열 일때는 바로 java 객체와 매핑될 수 없기 때문에,
	 							  jackson 을 이용한 자동 매핑을 수행하려면 이 어노테이션을 붙여야 한다
	 -----------------------------------------------------------------------------------------*/
	@PostMapping("/api/news")
	public String regist(@RequestBody NewsRequestDTO newsRequestDTO) {
		log.debug("뉴스 등록 요청 받음");
		
		log.debug("subCategory id is {}", newsRequestDTO.getSubCategoryId());
		log.debug("subject is{}", newsRequestDTO.getSubject());
		log.debug("author is{}", newsRequestDTO.getAuthor());
		log.debug("detail is{}", newsRequestDTO.getDetail());
		
		return null;
	}

}
