package com.hexagon.myapp.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hexagon.myapp.restaurant.Cook;
import com.hexagon.myapp.restaurant.FryingPan;
import com.hexagon.myapp.restaurant.Induction;
import com.hexagon.myapp.school.Bell;
import com.hexagon.myapp.school.Student;

//이 클래스의 목적은 로직을 작성하기 위함이 아니라, 과거에 사용되는 빈 설정 xml 을 대신한, 빈 설정 목적으로 정의함
//이 클래스에는 개발자가 애플리케이션에서 사용할 모든 빈들을 등록해야 함..
@Configuration	//이 클래스는 java 의 설정용이지 로직용이 아님..
@EnableAspectJAutoProxy
@EnableWebMvc	//MVC 패턴에 흐름을 처리할 수 있도록 MVC 지원 어노테이션 명시
//@Controller, @RestController, @Service, @Repository, @Component 등의 일명 스프링의 컴포넌트 빈들을
//메모리에 자동으로 올리려면 개발자는 이 컴포넌트들의 위치를 등록해야 한다..
@ComponentScan(basePackages = {"com.hexagon.myapp.controller"})
//지정한 패키지에 들어있는 클래스들 중 컴포넌트가 명시되어 있는 것은 죄다 ~ 찾아서 인스턴스 자동으로 생성하라!
public class AppConfig {
	
	//	/WEB-INF/views/      news/list       .jsp
	
	//하위 컨트롤러가 반환한 String 뷰 이름을 이용하여, 완전체 경로를 반환해주는 Resolver
	//즉 접두어와 접미어를 붙여 완전한 경로의 jsp를 반환해주는 뷰해결사!!
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");	//접두어 알려줌
		resolver.setSuffix(".jsp");	//접미어 알려줌
		return resolver;
	}
	
	//후라이팬을 스프링이 관리할 수 있도록 빈으로 등록
	@Bean
	public FryingPan fryingPan() {
		return new FryingPan();
	}
	
	@Bean
	//인덕션을 스프링이 관리할 수 있도록 빈으로 등록
	public Induction induction() {
		return new Induction();
	}
	
	//요리사
	@Bean
	public Cook cook(){
		return new Cook(fryingPan());
	}
	
	@Bean
	public Student student() {
		return new Student();
	}
	
	@Bean
	public Bell bell() {
		return new Bell();
	}
}
