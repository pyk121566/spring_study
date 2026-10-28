package com.hexagon.springmvc.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class News {
	private int newsId;
	private String title;
	private String writer;
	private String content;
	private LocalDateTime CreateAt;
	private int hit;
	private SubCategory subCategory;		//부모를 숫자따위가 아닌 부모자료형으로 보유함..
}
