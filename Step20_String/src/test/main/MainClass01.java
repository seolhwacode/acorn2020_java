package test.main;

public class MainClass01 {

	public static void main(String[] args) {
		String name1 = "강륜화";
		String name2 = "강륜화";
		String name3 = new String("강륜화");
		String name4 = new String("강륜화");
		
		// " 로 만든 문자열의 참조값 비교
		boolean result1 = name1 == name2;
		// " 로 만든 문자열과 new 로 만든 문자열의 참조값 비교
		boolean result2 = name1 == name3;
		// new 로 만든 문자열의 참조값 비교
		boolean result3 = name3 == name4;
		
		//문자열의 내용을 비교할 때는 '.equals()' 메소드를 이용한다.
		boolean result4 = name1.equals(name2);
		boolean result5 = name1.equals(name3);
		boolean result6 = name3.equals(name4);
		
	}

}
