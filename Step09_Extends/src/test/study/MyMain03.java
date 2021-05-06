package test.study;

import test.human.Blood;
import test.human.Men;
import test.human.Person;
import test.human.Woman;

public class MyMain03 {

	public static void main(String[] args) {
		//프로그래밍의 목적이 걷는 것이다. 어떻게 하면 걸을 수 있을까?
		Person person = new Person(new Blood("rh+", "O"));
		person.walk();
		
		//영화를 보려면!?
		Men m = new Men(new Blood("+", "A"));
		m.seeMovie();
		
		//독서 하려면?
		Woman w = new Woman(new Blood("+", "B"));
		w.reading();
		//부모의 메소드 호출 해보기
		w.walk();
		w.study();
		//다형성 확인하기
		Person w2 = w;
		Object w3 = w;
		

	}

}
