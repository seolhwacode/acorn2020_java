package test.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass04 {
	public static void main(String[] args) {
		String line = "2020-05-18 12:10";
		//특정 문자열에서 정규표현식에 맞아떨어지는 것들만 추출하고싶다.
		//여기서는 숫자만 빼오고싶다!
		//"[\\d]" : [숫자 0-9] 랑 같다.
		String regex = "[0-9]+";
		
		/* <pattern 의 method>
			pattern.matcher(CharSequence input)
			pattern.split(CharSequence input)
		*/
		//정규식 표현을 이용해서 Pattern 객체를 얻어낸다.
		Pattern pattern = Pattern.compile(regex);
		//Pattern의 matcher() 메소드를 통해 Matcher 객체를 얻어낸다.
		Matcher matcher = pattern.matcher(line);
		
		//find() 후에 group() 을 호출하여 매칭된 문자열을 읽어온다.
		while(matcher.find()) {
			//
			String result = matcher.group();
			System.out.println(result);
		}
		System.out.println("main 메소드가 종료됩니다.");
		
	}
}
