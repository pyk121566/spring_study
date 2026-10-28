package com.hexagon.myapp.school;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

// 이 벨 객체는 애플리케이션의 여러 영역에서 두루두루 사용할 공통 로직이므로
//AOP를 적용하기 위해 하나의 관점(Aspect)으로 빼두자!!
@Aspect
public class Bell {

	//AOP 는 원래 스프링의 기술이 아니라, AspectJ 라는 기술로 존재하였음.
	//따라서 딩동댕이 언제 핵심로직 메서드에 관여할지에 대한 설명 표현식은 aspectJ 에서 정한 표현식을 따른다.
	@After("execution(* com.hexagon.myapp.school.Student.*(..))")
	public void ding() {
		System.out.println("딩동댕♬");

	}
}
