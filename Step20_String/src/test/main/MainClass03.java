package test.main;

import java.util.Scanner;

public class MainClass03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("아이디 입력(영문자로 시작, 특수문자 허용하지 않음): ");
		String line = scan.nextLine();
		
		//첫 문자는 a-z, A-Z 즉, 영문자로 시작
		//\w : 특수문자를 제외한 0-9, a-z, A-Z 만 포함
		//+ : 1개 이상
		//^...$ : 시작과 끝
		String reg = "^[a-zA-Z][\\w]+$";
		
		//line.matches(Stirng regex): boolean
		//정규식 regex 의 조건을 만족시키면 true, 그렇지 못하면 false
		boolean isMatch = line.matches(reg);
		
		if(isMatch) {
			System.out.println("제대로 입력 했군요.");
		}else {
			System.out.println("아이디를 확인하세요.");
		}

	}

}
