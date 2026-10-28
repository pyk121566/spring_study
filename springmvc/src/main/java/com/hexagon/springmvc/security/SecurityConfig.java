package com.hexagon.springmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration	//로직용이 아닌 스프링 시큐리티관련 설정 클래스임을 명시
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final LoginSuccessHandler loginSuccessHandler;	//@RequiredArgsConstructor 로 자동주입 받자
	private final LoginFailureHandler loginFailureHandler;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http
			.csrf(csrf -> csrf.disable())	//공부목적상 csrf 설정은 생략한다
			
			.authorizeHttpRequests( auth -> 
				auth.anyRequest().authenticated()	//이 애플리케이션으로 들어오는 모든 요청은 인증이 적용되어있다. (따라서 로그인하지않은 요청은 자동으로 로그인폼으로 보내버림)
 			)
			.formLogin(form -> form
				.loginPage("/loginform")	//개발자가 정의한 로그인폼(커스텀 로그인 폼) 주소 설정
				.loginProcessingUrl("/login")	//UsernamePasswordAuthenticationFilter 를 어떤 주소로 만날지 결정..
				.usernameParameter("accountId") //UsernamePasswordAuthenticationFilter 에게 알려줌 (로그인 아이디 파라미터명을...)
				.passwordParameter("pwd") //UsernamePasswordAuthenticationFilter 에게 알려줌 (비밀번호 파라미터명을...)
				.successHandler(loginSuccessHandler)
				.failureHandler(loginFailureHandler)
				.permitAll()
			);
		
		return http.build();
	}
	//우리 대신 비밀번호를 검증해주는 빈 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
