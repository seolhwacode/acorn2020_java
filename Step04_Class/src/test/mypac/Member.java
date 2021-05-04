package test.mypac;

public class Member {
	//non static 필드 정의하기
	public int num;
	public String name;
	public String addr;
	
	//non static 메소드 정의하기
	//void : 아무 값도 없다.
	//-> 여기서는 return 값이 없음을 의미한다.
	public void showInfo() {
		System.out.println(num+" | "+this.name+" | "+this.addr);
		Member aMember =  this;	//this는 객체 자신을 의미하므로, Member 타입
	}
}






