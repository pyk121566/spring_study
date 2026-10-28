package com.hexagon.myapp.restaurant;

public class Induction implements Pan{
	@Override
	public void boil() {
		System.out.println("음식을 전기로 데워요");
	}
}
