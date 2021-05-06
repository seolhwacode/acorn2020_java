package test.mypac;

public class Messenger {
	/*<접근 지정자>
	 * 1. public : 어디서든 접근 가능
	 * 2. private : 동일 클래스 내에서만 접근 가능
	 * 3. protected : 동일 패키지와 상속 받은 클래스 내부에서만 접근 가능
	 * 4. default : 동일 패키지 내에서만 접근 가능
	 */
	//String type  을 인자로 전달받는 static 메소드 
	public static void sendMessage(String msg) {
		System.out.println(msg+" 를 전송 합니다.");
	}
	//String type  을 리턴해주는 static 메소드 
	public static String getMessage() {
		return "hello";
	}
	//Car type 을 인자로 전달 받는 static  메소드 
	public static void useCar(Car c) {
		c.drive();
	}
}


