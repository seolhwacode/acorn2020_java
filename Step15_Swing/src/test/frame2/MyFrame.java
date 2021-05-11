package test.frame2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public static final int TEMP = 0;
	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		//JFrame 의 static final 상수 값. field.
		//-> extends 상속 했기 때문에 JFrame.EXIT_ON_CLOSE 할 필요 없이 바로 사용할 수 있다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//레이 아웃 메니저를 FlowLayout 으로 지정한다.
		//setLayout(new FlowLayout(0));
		//FlowLayout.LEFT : 0 왼쪽 정렬, RIGHT : 2 오른쪽 정렬 / CENTER : 1 중앙정렬
		// LEFT,RIGHT,CENTER : static final int 상수이다.
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton btn1=new JButton("버튼1");
		add(btn1);
		
		JButton btn2=new JButton("버튼2");
		add(btn2);
		
		JButton btn3=new JButton("버튼3");
		add(btn3);
		
		JButton btn4=new JButton("버튼4");
		add(btn4);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame("나의 프레임");
	}
}








