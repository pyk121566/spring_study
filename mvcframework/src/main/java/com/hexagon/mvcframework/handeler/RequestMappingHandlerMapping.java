package com.hexagon.mvcframework.handeler;

import java.io.FileInputStream;

import lombok.extern.slf4j.Slf4j;

/* --------------------------------------------------------------------------
 클라이언트의 각 요청에 대해 어떤 컨트롤러가 동작해야하는지 매핑 파일을 조회하고 , 
 해당 컨트롤러의 인스턴스를 DispatcherServlet 에게 제공한다 
------------------------------------------------------------------------------  */
@Slf4j
public class RequestMappingHandlerMapping {
	
	public RequestMappingHandlerMapping(String path) {
	//매핑 파일을 접근하여 각 요청에 어떤 클래스가 동작해야 하는지에 대한 정보를 보관해놓자!!
		//WEB-INF/mapping.properties 경로는 완전한 풀 경로가 아니므로, FIleInputStream 이 접근할 수 없다..
		//해결책? 하나의 애플리케이션 마다 할당되는 application 내장개게(jsp) 인 ServletContext 객체를 이용하여 현재 애플리케이션에 들어있는 파일들의
		//IOS 상의 풀경로를 얻어오는 방법이 있다.
	try(FileInputStream fis = new FileInputStream(path)){
		log.debug("파일 접근 성공");
	}catch(Exception e) {
		log.debug("파일 경로를 확인해주세요");
		e.printStackTrace();	//에러 로그
		}
	}
}
