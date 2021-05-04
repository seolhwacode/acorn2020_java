package test.study;

import java.io.PrintStream;

import test.mypac.Car;

public class MyMain02 {

	public static void main(String[] args) {
		//System class
		//- static 멤버변수와 메소드를 가지고 있다.
		//- static은 외부에서 class명.static_변수명, class명.static_method() 로 사용이 가능하다. 
		PrintStream p = new PrintStream(System.out);
		p.println("Hello");
		
		//System.currentTimeMillis() : 1970년 1월 1일부터 현재시간까지 얼마나 시간이 흘렀는지, millisecond 단위로 반환
		//-> 나중에 프로그램의 실행에서 얼마나 걸렸는지 체크할 때 사용한다.
		long current = System.currentTimeMillis();
		p.println(current);
		
		//문자열은 자주 쓰는 class 이므로, 약식으로 "" 로 String 객체를 생성하게 지원하고 있다.
		String str = new String("안녕하세요");
		String str2 = "안녕하세요";
		
		Car c1 = new Car();
		
	}

}
