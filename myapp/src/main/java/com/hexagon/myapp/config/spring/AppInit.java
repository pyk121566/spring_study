package com.hexagon.myapp.config.spring;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 	전통적인 spring 3까지는 web.xml 을 주로 사용하였으나, 4부터는 xml 대신 java 클래스가 설정을 대신하는 분위기..
 	아래의 클래스에서는 우리가 지금까지 사용해왔던 web.xml 을 java 로 표현해 보겠다..
 */
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	//이 DispatcherServlet 이 접근할 수 있는 빈들을 관리하는 스프링 컨테이너를 생성하자!!
	//개발자는 여기서 스프링컨테이너가 관리할 빈들을 명시한 java Config 클래스를 등록해야 한다..
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {
			AppConfig.class		//요리사,인덕션,학생,Bell 등등 현재 애플리케이션에서 사용 할 빈들이 등록되어있는 설정 파일
		};
	}

	//필터매핑
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);	//request, response 모두 UTF-8 로 강제(기타 인코딩이 넘어와도 UTF-8로 강제)
		
		return new Filter[] {encodingFilter};
	}
	
	/* 모든 요청을 받아야 하므로, / 로 받자!
	 *<servlet-mapping>
	 *		<servlet-name></servlet-name>
	 *		<url-pattern></url-pattern>
	 *</servlet-mapping> 
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
}
