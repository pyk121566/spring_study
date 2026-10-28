package com.hexagon.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hexagon.springmvc.common.web.Pager;
import com.hexagon.springmvc.domain.Emp;

// @Mapper 어노테이션을 붙이면 Mapper.xml 을 간접제어할 수 있다.
// 즉 Mapper.xml 의 모든 id 와 동일한 메서드를 정의해야 함!! 
// 결과적으로 Mapper 인터페이스를 사용하게 되면, DAO 를 대신한다
@Mapper
public interface EmpMapper {
	public int insert(Emp emp);
	
	//public List selectAll(@Param("offset) int offset, @Param();
	public List selectAll(Pager pager);
	public int selectTotalCount();
	public Emp select(int empId);
}
