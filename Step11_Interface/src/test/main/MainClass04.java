package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 뚤어요");
			}
		});
		
		//람다함수
		//interface 에 하나의 함수만 가지고 있는 경우.(함수형 인터페이스-@FunctionalInterface)
		//위 익명 클래스의 줄임말과 같다.
		Drill d1=()->{
			System.out.println("벽에 20mm 의 구멍내기");
		};
		
		useDrill(d1);
		useDrill(()->{
			System.out.println("핸드폰에 1mm 구멍내기");
		});
		
	}
	
	public static void useDrill(Drill d) {
		d.hole();
	}
}





