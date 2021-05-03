package test.study;

public class MainClass03 {
	public static void main(String[] args) {
		//자바에서 객체는 저장소(field)와 기능(method)으로 이루어져 잇다.
		
		//기본 데이터 type 지역변수
		int a = 10;
		double b = 10.1;
		boolean c = true;
		
		//참조 데이터 type 지역변수
		String d = "김구라";
		//참조값에 . 을 찍어서 length() 메소드를 호출하면 문자열의 길이를 return 한다.
		int result = d.length();
		//참조값에 . 찍어서 charAt(int index) 메소드를 호출하면 index 해당되는 char 가 리턴된다.
		char ch1 = d.charAt(0);
		char ch2 = d.charAt(1);
		char ch3 = d.charAt(2);
		//참조값에 . 을 찍어서 toCharArray() 메소드를 호출하면 char 배열이 리턴된다.
		char[] charArr = d.toCharArray();
		System.out.println(charArr);
	}
}
