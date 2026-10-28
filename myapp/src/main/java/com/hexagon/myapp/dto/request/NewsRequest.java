package com.hexagon.myapp.dto.request;

import lombok.Getter;
import lombok.Setter;

//클라이언트의 요청을 받는 DTO 정의!!!
//멤버변수명은 html 의 파라미터명(name)과 일치시켜야 한다
//주의 !! 데이터베이스명과 일치시키는 규칙을 고수한다면, html 파라미터 이름만으로도 외부에서 db 컬럼명을 예측할 수 있게 되어버림
//따라서 보안상 중요한 컬럼명의 경우엔 이름을 다르게 하자!!
@Getter
@Setter
public class NewsRequest {
	private String title;
	private String writer;
	private String content;
}
