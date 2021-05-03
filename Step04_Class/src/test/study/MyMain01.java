package test.study;

//다른 패키지에 있는 class를 사용하려면 import 해야한다.
import test.mypac.Car;

public class MyMain01 {

	public static void main(String[] args) {
		//다른 패키지에 있는 class를 사용하려면 import 해야한다.
		//Car + ctrl + space -> Car를 찾아 자동으로 import와 함께 new 생성자 함수 완성
		Car car1 = new Car();
		Car car2 = new Car();
		
	}

}
