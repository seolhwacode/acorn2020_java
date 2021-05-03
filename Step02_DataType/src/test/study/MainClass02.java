package test.study;

public class MainClass02 {

	public static void main(String[] args) {
		//변수를 선언만 하고 초기화하지 않을 때, 어떻게 되는가?
		//-> 지역변수는 선언만 하면 변수가 만들어지지 않고, 만들 준비만 한다.
		System.out.println("main 메소드가 시작되었습니다.");
		
		int num1;
		int num2 = 0;
		int num3 = 10;
	
		//값이 대입되는 시점에 변수가 만들어진다.
		num1 = -1;
		
		String name;
		String name2 = null;
		String name3 = "김구라";
		
		System.out.println("main 메소드가 종료됩니다.");

	}

}
