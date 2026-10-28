package com.hexagon.springmvc.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordCreator {

	public static void main(String[] args) {
		//암호화에 사용할 알고리즘은 상당히 많다. 하지만 스프링은 BCrypt 알고리즘을 사용한다.
		
		//암호화할때마다 사용될 salt 를 랜덤하게 발생시켜 같은 평문을 암호화시키더라도 
		//암호화할때마다 틀려지게 하는 알고리즘
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword= encoder.encode("1234");
		System.out.println("결과는 "+encodedPassword);
	}

}
