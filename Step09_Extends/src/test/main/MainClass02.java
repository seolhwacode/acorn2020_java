package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass02 {
	public static void main(String[] args) {
		//다형성 : 하나의 객체가 여러 가지 타입을 가질 수 있는 것
		//상위 클래스 데이터타입에 담게 되면, 하위 클래스에서 정의된 기능을 하용할 수 없다.
		//-> 그래도 사용하는 이유 : 유연한 프로그래밍을 가능케 한다.
		
		
		//SmartPhone 객체를 생성해서 SmartPhone type 의 지역변수 p1 에 담기 
		SmartPhone p1=new SmartPhone(); 
		//p1 에 담긴 참조값을 HandPhone type 지역변수 p2 에 담기
		HandPhone p2=p1;
		
		//HandPhone 타입에 담아도, overide로 재정의된 takePicture은 SmartPhone에서
		//재정의한 내용이 실행된다.
		p2.takePicture();
		
		//p1 에 담긴 참조값을 Phone type 지역변수 p3 에 담기
		Phone p3=p1;
		//p1 에 담긴 참조값을 Object type 지역변수 p4 에 담기 
		Object p4=p1;

		MainClass02.usePhone(p1);
	}
	
	public static void usePhone(Phone p) {
		p.call();	//p가 실제로는 SmartPhone이라도 다른 기능을 사용할 수 없다.
		
		//명시적인 형변환을 사용하여 Phone 타입 p를 SmartPhone로 만든다.
		SmartPhone sp = (SmartPhone)p;
		sp.doInternet();	//사용 가능!
		
	}
}










