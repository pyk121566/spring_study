package com.hexagon.myapp.restaurant;

//전기기반의 인덕션이건, 불로 데우는 프라이팬이건 상관없이 둘다 가리킬 수 있는 최상위 팬!!
//추상클래스를 굳이 사용하지 않는 이유는? 혹여나 구현 자식 클래스에서 다중 상속의 문제가 발생할 수 있으므로..
public interface Pan {
	public void boil();	 //기준만 세운다..
}
