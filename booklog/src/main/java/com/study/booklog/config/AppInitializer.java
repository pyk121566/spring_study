package com.study.booklog.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() { //부모 컨테이너 설정 클래스 지정
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() { //DispatcherServlet의 설정 클래스 지정
		return new Class<?>[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {  //DispatcherServlet의 URL 매핑 지정
		return new String[] {"/"};
	}

	protected Filter[] getServletFilters() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		return new Filter[] {filter};
	}
	
}
