package test.main;

public class MainClass02 {

	public static void main(String[] args) {
		String str = "abcde강륜화12345";
		//4번째 인덱스에 있는 문자열 얻어오기
		char a = str.charAt(4);

		//문자열 합치기
		String b = str.concat("fghij");
		System.out.println(b);
		
		//문자열이 포함되어 있는지 여부 얻어내기
		//String은 CharSequence 를 구현하고 있기 때문에, 
		//CharSequence 타입 parameter 로 넘길 수 있다.
		boolean c = str.contains("123");
		
		//해당 문자열이 몇번재 인덱스에 있는지 알아내기 (없으면 -1)
		int d = str.indexOf("강륜화");
		System.out.println(d);
		
		//문자열의 길이 얻어내기
		int e = str.length();
		
		//regex : 정규표현식(Regular expression)
		//split(String regex): String[]
		String line = "김구라/해골/원숭이/주뎅이/덩어리";
		String[] result1 = line.split("/");
		
		String line2 = "김구라    해골    원숭이    주뎅이    덩어리";
		String[] result2 = line2.split("[ ]+");
		
		String line3 = "김구라abcd   ef해골   as   bd4 원숭이   주뎅이   mdfks   덩어리";
		String[] result3 = line3.split("[a-z0-9 ]+");
		
		//replaceAll(String regex, String replacement): String
		//regex 에 해당되는 문자열을 replacement 문자열로 교체하기
		String line4 = "김구라바보,해골바보,원숭이바보";
		String result4 = line4.replaceAll("바보", "천재");

		//[^] : ^ 는 not 을 의미한다.
		//특수문자가 제거되는 효과를 가질 수 있다.
		/*
		 * in javascript => /[^\w]/
		 * in java => "[^\\w]"
		 * 
		 * in javascript => /a\\b/
		 * int java => "a\\\\b"
		 * 
		 * - java 에서 정규식 표현식을 작성할 때, 역슬래시를 하나 넣고싶으면 2개를 넣으면 된다.
		 */

		String line5 = "abc    가나   123   efg   @!$ def  456";
		String result5 = line5.replaceAll("[^A-Za-z0-9]+", "");
		String result6 = line5.replaceAll("[^\\w]", "");
		String result7 = line5.replaceAll("[\\W]", "");
		System.out.println(result6);
		System.out.println(result7);
		
		//endsWith(String suffix): boolean
		//- str 이 suffix 문자열로 끝나면 true
		//- suffix 가 빈 String("") 이거나 호출하는 str 과 같을 때(equals()) true 를 return
		String test = "abcd";
		System.out.println(test.endsWith("abcd"));
		
		//replace(char oldChar, char newChar): String
		String test2 = "apple plus ping pong";
		System.out.println(test2.replace('p', '@'));
		System.out.println(test2.replaceFirst("[p]+", "@"));
		
	}

}
