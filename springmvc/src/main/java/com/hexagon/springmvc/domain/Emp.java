package com.hexagon.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

//이 클래스는 html 파라미터를 받는 DTO 가 아니라, db 의 테이블과의 CRUD 에 사용될 domain 객체이다.
@Getter
@Setter
public class Emp {
	private int empId;
	private String ename;
	private int age;
	private String email;	
	private Bio bio;
	
}
