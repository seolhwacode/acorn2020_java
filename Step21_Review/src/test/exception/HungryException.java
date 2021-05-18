package test.exception;

public class HungryException extends RuntimeException{

	public HungryException(String msg) {
		//생성자의 인자로 전달받은 예외 메시지를 부모 생성자에게 전달하기
		super(msg);
	}
	
}
