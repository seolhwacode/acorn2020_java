package test.frame10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame 
					implements ActionListener, KeyListener{
	//필드
	JTextField inputMsg;	//텍스트 입력 필드
	JLabel lab1;		//텍트 출력
	
	/* <JList>
	 * - 요소 객체들의 리스트를 보여주는 component
	 * - 사용자에게 리스트의 요소 객체를 하나를 선택 or 여러개를 선택 할 수 있게 할 수 있다.
	 * - 각 요소는 기본 모델 객체 ( 목록에 출력할 data 를 가지고 있는 객체 )
	 */
	DefaultListModel<String> model;	//기본 모델 객체 ( 목록에 출력할 data 를 가지고 있는 객체 )
	JList<String> list;	//위에 설명
	
	//static final 상수
	static final String COMMAND_SEND="send";
	static final String COMMAND_REMOVE="remove";
	
	
	//default  생성자
	public MyFrame() {
		//BorderLayout : NORTH / WEST / EAST / SOUTH / CENTER 에 위치시킬 수 있다.
		setLayout(new BorderLayout());
		//문자열 한줄을 입력할수 있는 JTextField
		inputMsg=new JTextField(10);
		//MyFrame 은 KeyListener 를 구현하고있다.
		inputMsg.addKeyListener(this);
		
		//전송 버튼
		JButton sendBtn=new JButton("전송");
		sendBtn.setActionCommand(COMMAND_SEND);	//command 추가
		sendBtn.addActionListener(this);
		//삭제 버튼
		JButton removeBtn=new JButton("선택 삭제");
		removeBtn.setActionCommand(COMMAND_REMOVE);
		removeBtn.addActionListener(this);
		//삭제 버튼 하단에 배치하기 
		add(removeBtn, BorderLayout.SOUTH);
		
		//JLabel 객체 생성
		lab1=new JLabel("label입니다.");
		
		//JPanel 객체 생성 : 가벼운 Component
		JPanel panel=new JPanel();
		//페널도 레이아웃을 지정할수 있다( 기본값은 FlowLayout 가운데 정렬이다 )
		//왼쪽 정렬
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		//JPanel 에 UI 추가 하고 
		panel.add(inputMsg);	//텍스트 입력 필드 추가 (JTextField)
		panel.add(sendBtn);		//sendBtn 추가 (JButton)
		panel.add(lab1);		//lab1 추가 (JLabel)
		//페널에 배경색 지정하기 
		panel.setBackground(Color.YELLOW);
		
		//JFrame 에 JPanel 을 북쪽에 배치하기 
		add(panel, BorderLayout.NORTH);
		//목록을 출력할수 있는 JList 
		list=new JList<String>();
		
		//기본 모델 객체 ( 목록에 출력할 data 를 가지고 있는 객체 )
		model=new DefaultListModel<String>();
		model.addElement("김구라");
		model.addElement("해골");
		model.addElement("원숭이");
		
		//목록에 모델 연결하기 
		list.setModel(model);
		
		//스크롤 페널에 목록 넣어주기
		//JScrollPane(Component view, int 세로 스크롤, int 가로 스크롤)
		JScrollPane sc=new JScrollPane(list, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
//		sc.setBackground(Color.BLUE);	-> 이건 안되나?
		//스크롤 페널을 프레임의 가운데에 배치하기 
		add(sc, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		//MyFrame 클래스를 이용해서 객체 생성하고 참조값을 지역변수 frame 에 담기 
		MyFrame frame=new MyFrame();
		//프레임의 제목 설정
		frame.setTitle("나의 프레임");
		//프레임을 닫으면 자동으로 프로세스가 종료 되도록 한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}
	
//ActionListener
	//ActionListener 인터페이스를 구현 해서 강제 오버라이드된 메소드 
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 command  를 읽어온다.
		String command=e.getActionCommand();
		if(command.equals(COMMAND_SEND)) {//전송 버튼을 눌렀을때
			send();
		}else if(command.equals(COMMAND_REMOVE)) {//삭제 버튼을 눌렀을때
			//JList 객체에게 선택된 item 이 있는지 있다면 몇번째 아이템이 선택되었는지
			//물어 봐야 한다. (메소드를 이용해서 알아낸다)
			//아무것도 선택하지 않았으면 -1 return / 선택이 있으면 해당 index 를 return
			int selectedIndex=list.getSelectedIndex();
			if(selectedIndex >= 0) {//선택된 cell 이 있을때 
				//정말로 삭제 할것인지 물어본다.
				//YES(JOptionPane.YES_OPTION = 0), NO, CANCLE ... int 값을 return 한다.
				int result=JOptionPane.showConfirmDialog(this, "삭제 할겨?");
				//Yes 옵션 선택
				if(result==JOptionPane.YES_OPTION) {
					//JList 에 연결된 모델에서 해당 인덱스를 삭제한다. 
					model.remove(selectedIndex);
				}	
			}else {//선택된 cell 이 없을때
				JOptionPane.showMessageDialog(this, "삭제할 cell 을 선택하세요");
			}
		}
	}
	
	//메소드 추가
	//sendBtn 을 눌렀을 때 실행되는 method
	//JTextField 에 입력한 문자열을 읽어와서, JLabel에 출력, JList 에 출력하기 위해, 그 안의 model 에 객체를 추가한다.
	public void send() {
		//JTextField 에 입력한 문자열을 읽어와야한다.
		String msg=inputMsg.getText();
		//읽어온 문자열을 JLabel 에 추가하기
		lab1.setText(msg);
		//입력창 문자열 삭제 하기 
		inputMsg.setText("");
		//모델에 입력한 문자열 추가하기
		model.addElement(msg);
	}
	
//KeyListener 재정의 메소드
	
	//키를 눌렀을때 호출되는 메소드 
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println("pressed");
		//눌러진 키보드의 코드값을 읽어온다.
		int code=e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {//엔터키를 눌렀다면 
			send();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("released");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("typed");
	}
}






