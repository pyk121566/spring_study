package com.hexagon.mvcframework.dispatcher;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hexagon.mvcframework.handeler.RequestMappingHandlerMapping;

import lombok.extern.slf4j.Slf4j;

/*
애플리케이션의 모든 요청을 받는 진입점 
  1. 요청을 받는다
  2. 요청을 분석한다(이 요청을 누가 처리할지를 결정짓고 해당 컨트롤러의 메서드 호출)
  5. 결과를 보여준다 
 */
@Slf4j
public class DispatcherServlet extends HttpServlet{
	RequestMappingHandlerMapping handlerMapping;
	
	//이 서블릿이 생성된 직후, 초기화를 위해 호출
	public void init(ServletConfig config) throws ServletException {
		ServletContext application = config.getServletContext();	//현재 애플리케이션에 대한 정보를 가진 전역 객체인 ServletContext 를 얻는다
		String contextConfigLocation = config.getInitParameter("contextConfigLocation");
		String realPath = application.getRealPath(contextConfigLocation);
		log.debug("매핑 파일의 OS상 실제 경로는 {}", realPath);
		
		handlerMapping = new RequestMappingHandlerMapping(realPath);
	}
	
	//서블릿의 생명주기 메서드(init, service, destory)중 요청을 처리하는 메서드인 service를 재정의한다!
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("요청 받았어");
	}
}
