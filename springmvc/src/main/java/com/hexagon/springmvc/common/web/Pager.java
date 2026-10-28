package com.hexagon.springmvc.common.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component	//개발자가 정의한 클래스를 컴포넌트로 선언하면, 이 컴포넌트를 자동 검색에 의해 스프링 컨테이너가 보유하게 되므로
					//필요할때 주입받아 쓰자!!
public class Pager {
	List list;		//추후 jsp 에서 pager 와 List 를 따로 가지고 다니지 않기 위해
	int totalCount;
	int pageSize=10;//한 페이지당 보여질 레코드 수
	int totalPage;
	int blockSize=10;  //한 블럭당 보여질 페이지 수
	int currentPage=1; //현재 보고있는 페이지	 , 게시판을 들어오자마자 보게되는 기본 페이지는 언제나 최신 게시물이 있는 1페이지 부터라서...
	int firstPage;
	int lastPage;
	int num;
	int offset;
	
	public void init(HttpServletRequest request) {	
		totalPage=(int)Math.ceil((float)totalCount/pageSize); //총 페이지 수
		//currentPage 는 유저가 원하는 페이지를 선택할 경우 , 그 페이지 값으로 대체가 되어야 한다..
		//즉 유저가 전송한 파리미터값으로 페이지값을 대신하자!!
		if(request.getParameter("currentPage")!=null){	//파라미터가 있을때만 수행해야함, 즉 게시판을 처음에 접속할때는 동작하지 말아라!!
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	//넘어온 "7"을 정수 7로 변환
		}
		firstPage=currentPage-(currentPage-1)%blockSize;	//블럭당 포문의 시작값 (힌트 - 기존의 선언된 변수들을 조합)
		lastPage=firstPage + (blockSize-1);	//블럭당 포문의 끝값
		
		offset=(currentPage-1)*pageSize; 
							//각 페이지 당 시작 index ( 가져온 리스트내에서... )
						//힌트 : currentPage 와 pageSize 만큼 비례하여 증가.. , 기존 변수들을 조합해서
						
		//현재 페이지가 증가할수록 num 은 totalCount 에서 pageSize 씩 비롛여 감소
		 num=totalCount - offset ;	//페이지당 시작 번호 ex)1 - 26, 2-16, 3-6
	}
}
