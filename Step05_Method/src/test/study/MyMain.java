package test.study;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MyMain {

	public static void main(String[] args) {
		MyObject o1 = new MyObject();
		o1.walk();
		int num = o1.getNumber();
		String greet = o1.getGreeting();
		/*
		 * 일한 패키지 혹은 java.lang 패키지에 속한 클래스가 아니면 반드시 import 해야 사용할 수 있다.
		 */
		//모든 객체를 다 생성하는 것이 아니고, method가 리턴해주는 객체를 사용할 수도 있다.
		Car car1 = o1.getCar();
		car1.drive();
		
		//메소드를 호출하면서 적절한 tpye 데이터를 전달해야 메소드를 호출할 수 있다.
		o1.setNum(1000);
		int num1 = 999;
		//int type 데이터가 들어있는 변수명으로 데이터를 전달할 수도 있다.
		o1.setNum(num1);
		
		//void setName(String name)
		//1)
		String name1 = "사람이름";
		o1.setName(name1);
		//2)
		o1.setName("사람이름2");
		
		//void useCar(Car car)
		//1)
		Car car2 = new Car();
		o1.useCar(car2);
		//2)
		o1.useCar(new Car());
		
		//void useSome(String name, Car car)
		//1)
		Car car3 = new Car();
		String name2 = "name";
		o1.useSome(name2, car3);
		//2)
		o1.useSome("이름", new Car());
		
		
		//void doSome(Radio r, Speaker s)
		//1)
		Radio radio = new Radio();
		Speaker speaker = new Speaker();
		o1.doSome(radio, speaker);
		//2)
		o1.doSome(new Radio(), new Speaker());
		
		

	}

}
