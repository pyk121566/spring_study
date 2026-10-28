package com.hexagon.springmvc.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hexagon.springmvc.domain.Bio;

//xml을 대신 제어해주는 인터페이스

//mybatis 의 쿼리문이 작성된 Mapper.xml 파일을 대신 제어해주는 인터페이스
@Mapper
public interface BioMapper {
	public int insert(Bio bio);
}
