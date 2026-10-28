package com.hexagon.myapp.school;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexagon.myapp.config.spring.AppConfig;

public class UseStudent {
	public static void main(String[] args) {
		
		//스프링이 관리하는 학생 인스턴트를 가져와서, 등교, 수업시작, 쉬는시간, 하교 메서드를 호출해보자!
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//학생 인스턴스 스프링에서 얻어오기
		Student student = (Student)context.getBean("student");
		
		student.gotoSchool();
		student.startLesson();
		student.endLesson();
		student.goHome();
	}
}
