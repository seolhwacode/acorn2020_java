package test.study;

public class MainClass01 {

	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		
//		1. 정수
		int num1 = 10;
		num1 = 20;
		
		byte num2 = 10;
		num2 = 20;
		//int type 변수에 byte type 변수 안에 있는 값을 대입하기
//		byte num3 = num1;	//문법 오류(compile 에러)
		
		//(byte) 는 형변환(casting) 연산자이다. -> 강제 형변환
		byte num3 = (byte)num1;
		
//		2. 실수
//		float num4 = 10.1;	//-> 오류 : 실수는 기본적으로 double
		double num4 = 10.1;		//묵시적인 double type
		double num5 = 10.1d;	//명시적인 double type
		float num6 = 10.1f;		//float는 반드시 명시적으로 f를 붙여서 만들어야한다.
		
//		double type 변수에 float type 변수에 있는 값 대입하기
		num4 = num6;
		
//		double type 변수에 있는 값을 float type 에 담을 때는 casting이 필요하다.
		float num7 = (float)num4;
		
	}

}
