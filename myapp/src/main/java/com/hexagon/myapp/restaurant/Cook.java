package com.hexagon.myapp.restaurant;

//요리사를 정의한다
public class Cook {
	//아래와 같이 has a 관계로 특정 클래스의 자료형을 직접 사용하게 될 경우, 만일 사용대상 클래스에 변경사항이 생기거나,
	//사라지게 되면, Cook 클래스도 영향을 받으므로, 개발 규모가 커지면 유지 보수성에 문제가 생기게 된다..
	//즉 Cook 클래스는 FryingPan 클래스에 의존적이다!!! ( 강한 결합도로 연결되어 있다 )
	Pan pan;	//has a
	
	//개발자가
	public Cook(Pan pan) {	//생성자
		this.pan = pan;
		//pan = new FryingPan(); new 연산자를 직접 이용하여 직접 생성할 경우, 또 다시 강한 결합도가 된다. 
		//따라서 스프링 이용 시 개발자는 사용하고 싶은 대상 객체를 직접 생성하지 않고, 스프링이 관리하는 컨테이너로부터 주입(Injection)받아야 한다.
	}
	
	public void makeFood() {
		pan.boil();
	}
}
