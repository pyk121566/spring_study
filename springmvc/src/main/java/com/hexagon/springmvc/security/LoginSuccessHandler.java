package com.hexagon.springmvc.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

//비밀번호 검증이 성공되면 , usernamePasswordAuthenticationToken이 생성되고 ,
//그 토큰이 UsernamePasswordAuthenticationFilter 로 도착하고, 이 필터가 
//로그인 성공했음을 저장(Securitycontext) 한 직후, 아래의 성공 핸들러를 호출한다.
//이 클래스에서 개발자는 성공의 응답정보를 만들어서 보냊두면 된다.
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	
		PrintWriter out = response.getWriter();
		out.print("login success");
		out.flush();
	}
	
	
}
