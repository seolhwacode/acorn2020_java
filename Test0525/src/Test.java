
public class Test {

	public static void main(String[] args) {
		Pen[] pens = { new Pen( ), new Pen( ), new Pen( ) };
		
		String[] friends = new String[5];
		friends[0] = "김구라";
		friends[1] = "원숭이";
		friends[2] = "주뎅이";
		friends[3] = "해골";
		friends[4] = "덩어리";
		
		for(int i = 0; i < friends.length; i++) {
			System.out.println(friends[i]);
		}
		
		int size = friends.length;
		
		for(int i = 0; i < friends.length; i++) {
			friends[i] = null;
		}
	
	}



}
	
