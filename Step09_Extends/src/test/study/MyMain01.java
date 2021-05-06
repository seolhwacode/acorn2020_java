package test.study;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MyMain01 {
	public static void main(String[] args) {
		/* <상속>
		 * - 상속받은 class 객체를 생성할 때, 상위의 상속된 class들의 객체 또한
		 * 힙에 같이 생성된다. 그리고 이들은 하나의 주소로 관리된다.
		 * - SmartPhone 객체를 생성하면 Phone, HandPhone, SmartPhone
		 * 객체가 모두 생성된다.상위 class의 생성자부터 호출된다.(모든 생성자가 호출된다.)
		 * - super : 바로 위의 부모 class를 가리키는 것
		 * 
		 * <Override(함수 재정의)>
		 * - @Override 는 부모의 메소드를 재정의한 메소드라고 표시 해주는 어노테이션
		 *
		 * <Object Class>
		 * - Object Class는 모든 object가 상속받는 객체이다.
		 */
		
		
		Phone p1 = new Phone();
		HandPhone p2 = new HandPhone();
		SmartPhone p3 = new SmartPhone();

		
		p3.call();
		p3.mobileCall();
		p3.doInternet();
		p2.takePicture();
		p3.takePicture();
	}
}
