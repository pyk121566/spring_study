package com.hexagon.springmvc.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hexagon.springmvc.domain.Admin;
import com.hexagon.springmvc.mapper.AdminMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 스프링 시큐리티에서 DB 연동이 시작되는 모델 영역의 객체
개발자는 여기서 자신이 사용하는 DB 기술에 적절한 코드를 작성해야 한다. 
JDBC - DAO 사용
MyBatis - Mapper 인터페이스 사용
Hibernate - 하이버네이트 Repository 사용
JPA - JPA Repository
*/
@Slf4j
@Service //우리의 경우 RootConfig 클래스 차원에서 빈 자동 검색 등록을 완료한 상태
@RequiredArgsConstructor	
public class CustomUserDetailsService implements UserDetailsService{

	private final AdminMapper adminMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.debug("로그인 시 사용된 아이디는{}", username);
		
		Admin admin = adminMapper.selectById(username);
		
		log.debug("사원 비번은 "+ admin.getPassword());
		log.debug("사원 명은 "+ admin.getName());
		
		//개발자가 return 에 UserDetails 객체를 반환하면 이 객체를 PasswordEncoder에게 맡겨서 비밀번호가 일치하는지 검증하는 단계에 들어감.
		return new AdminDetails(admin);
	}

	
}
