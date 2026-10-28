package com.hexagon.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bio {
	private int bioId;
	private float height;
	private float weight;
	private String bloodType;
	private Emp emp;	//db erd 상에서는 부모의 fk 로 표현되지만, java 에서는 부모 자료형을 보유해야 한다.
}
