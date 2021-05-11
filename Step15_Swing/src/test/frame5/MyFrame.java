package test.frame5;

import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	//default  생성자
	public MyFrame() {
		//MyFrame 의 레이아웃 메니저 지정하기
		setLayout(new FlowLayout());
		//버튼
		JButton sendBtn=new JButton("전송");
		JButton removeBtn=new JButton("삭제");
		//프레임에 버튼 추가하기 ( FlowLayout 의 영향을 받는다 )
		add(sendBtn);
		add(removeBtn);
		
		//여기서 this는 MyFrame 데이터타입이다.
		MyFrame aFrame = this;
		//Component는 JFrame 의 부모
		Component aComponent = this;
		
		JOptionPane.showMessageDialog(this, "오잉~?");
		
		//ActionListener 인터페이스 type  의 참조값 
		ActionListener listener=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("전송 합니다~");

				//여기서 this는 ActionListener 타입 데이터이다.
				ActionListener b = this;
				//그냥 this 를 하면 ActionListener 객체가 선택 되므로, MyFrame.this 를 해야한다.
				//showMessageDialog(Frame, msg) : 팝업창 메시지 띄우기
				JOptionPane.showMessageDialog(MyFrame.this, "전송합니다~");
			}
		};
		
		sendBtn.addActionListener(listener);
		//lamda 식 활용해 보기 
		removeBtn.addActionListener((e)->{
			JOptionPane.showMessageDialog(MyFrame.this, "삭제합니다~");
		});
	}
	
	public static void main(String[] args) {
		//MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame 에 담기 
		MyFrame frame=new MyFrame();
		//프레임의 제목 설정
		frame.setTitle("나의 프레임");
		//프레임을 닫으면 자동으로 프로세스가 종료 되도록 한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//x, y, width, height
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}
}






