package test.main;

import java.util.Random;

import test.exception.DoNotKonwException;
import test.exception.HungryException;

public class MainClass01 {

	public static void main(String[] args) {
		//공부하는 메소드s
		play();
		try {
			study();
		} catch (DoNotKonwException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		

		System.out.println("main 메소드가 정상 종료됩니다.");
	}
	//노는 메소드
	//HungryException : RunnableException 을 상속 받았기 때문에, 문법상 오류가 생기지 않는다.
	//	-> 선택적으로 처리하면 된다. 개발자가 처리하지 않으면, JVM(Java Virtual Machine) 으로 처리가 넘어가며 종료된다.
	public static void play(){
		Random random = new Random();
		int ranNum = random.nextInt(3);
		if(ranNum == 0) {
			throw new HungryException("야! 배고파!");
		}
		System.out.println("공부를 마쳤습니다.");
	}
	
	//공부하는 메소드
	//DoNotKonwException : RunnableException 을 상속 받지 않았기 때문에, 문법상 오류가 생긴다.
	//	-> 무조건 try ~ catch 로 처리해줘야한다.
	public static void study() throws DoNotKonwException{
		Random random = new Random();
		int ranNum = random.nextInt(3);
		if(ranNum == 0) {
			throw new DoNotKonwException("넘모 어려워요...ㅠㅠ");
		}
	}

}
