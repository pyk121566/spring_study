package com.hexagon.myapp.restaurant;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexagon.myapp.config.spring.AppConfig;

public class UseCook {

	public static void main(String[] args) {
		//DI를 구현하기 위해서는, 개발자가 사용하려는 객체(Bean)들을 스프링이 직접 생성 및 관리해야 하고,
		//주입도 시켜야 하므로 스프링 컨테이너부터 생성하자!!
		//스프링 컨테이너의 자료형은 ApplicationContext 이다..
		
		//과거에는 개발자가 사용할 빈들을 xml에서 관리했지만, 스프링 3.x 버전 이후 부터는 java 클래스 기반의 설정으로 바뀜..
		//개발자가 특정 클래스에 @Configuration 을 선언하면, 이 ApplicationCcontext가 메모리에 올라올 때
		//개발자가 설정한 빈들도 함께 올려서 컨테이너로 관리한다!!
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Cook cook = (Cook)context.getBean("cook");
		cook.makeFood();
		
	}

}
