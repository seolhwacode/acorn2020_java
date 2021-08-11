package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.BirthDao;
import test.dto.BirthDto;

public class BirthFrame extends JFrame 
				implements ActionListener, PropertyChangeListener{

	//필드
	//생일, 이름 입력 textField
	JTextField inputBirthdayTextField, inputNameTextField;
	//table 을 위한 모델 & 테이블
	DefaultTableModel model;
	JTable table;
	
	//list
	List<BirthDto> list = null;
	
	//입력 JTextField 폭 넓이
	static final int TEXT_FIELD_SIZE = 15;
	
	public BirthFrame() {
		//JFrame 의 layout 은 BorderLayout (NORTH, EAST, WEST, SOUTH, CENTER)
		setLayout(new BorderLayout());
		
		//이름 입력을 위한 JLabel, JTextField
		JLabel nameLabel = new JLabel("이름");
		inputNameTextField = new JTextField(BirthFrame.TEXT_FIELD_SIZE);
		
		//생일 입력을 위한 JLabel, JTextField
		JLabel birthdayLabel = new JLabel("생일");
		inputBirthdayTextField = new JTextField(BirthFrame.TEXT_FIELD_SIZE);

		//저장 버튼 - actionCommand = "save"
		//		- 현재 BirthFrame 는 ActionListener 구현
		JButton saveBtn = new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);
		
		//삭제 버튼 - actionCommand = "delete"
		//		- 현재 BirthFrame 는 ActionListener 구현
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		//새로고침 버튼 - db 에서 모든 정보를 가져와서 table 로 출력하여 새로고침 해줌
		JButton refreshBtn = new JButton("새로고침");
		refreshBtn.setActionCommand("refresh");
		refreshBtn.addActionListener(this);
		
		//JPanel 에 JLabel, JTextField, 버튼들 추가
		JPanel panel = new JPanel();
		panel.add(nameLabel);
		panel.add(inputNameTextField);
		panel.add(birthdayLabel);
		panel.add(inputBirthdayTextField);
		panel.add(saveBtn);
		panel.add(deleteBtn);
		panel.add(refreshBtn);
		
		//배경색 설정
		panel.setBackground(Color.GREEN);
		
		//panel 을 북쪽에 배치
		add(panel, BorderLayout.NORTH);
		
		//표형식으로 정보를 출력하기 위한 JTable
		table = new JTable();
		//칼럼명을 String[] 에 순서대로 준비
		String[] colNames = {"번호", "이름", "생일"};
		//테이블에 출력할 정보를 가지고 있는 모델 객체(컬럼명, row 개수)
		model = new DefaultTableModel(colNames, 0) {
			//인자로 전달되는 행(row), 열(column) 수정 가능 여부를 리턴하는 메소드  
			//위의 DefaultTableModel 에 오른쪽 클릭 > Source > Override/Implements method ... > 필요한 것 선택 > OK
			@Override
			public boolean isCellEditable(int row, int column) {
				//첫 번째(num) 컬럼은 수정이 불가능하다.
				if(column == 0) return false;
				//나머지는 수정 가능
				return true;
			}
		};
		
		//모델을 테이블에 연결
		table.setModel(model);
		//스크롤이 가능하도록, 테이블을 JScrollPane 에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		//JScrollPane 을 프레임의 가운데에 배치하기 
		add(scroll, BorderLayout.CENTER);
		//테이블에 메모 목록 출력하기
		displayBirth();
		
		//테이블에서 발생하는 이벤트 리스너 등록 하기
		//PropertyChangeListener : propertyChange() 오버라이드. 이 메소드가 실행된다.
		table.addPropertyChangeListener(this);
	}

	//main  메소드
	public static void main(String[] args) {
		BirthFrame f=new BirthFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
	
	public void displayBirth() {
		//row  의 갯수를 강제로 0 으로 지정해서 삭제 한다.
		model.setRowCount(0);
		//생일 목록을 얻어와서 
		BirthDao dao = BirthDao.getInstance();
		list = dao.getList();
		for(BirthDto tmp:list) {
			//BirthDto 객체에 저장된 정보를 Object[] 객체에 순서대로 담는다.
			Object[] row = {tmp.getNum(), tmp.getName(), tmp.formatBirthday()};
			model.addRow(row);
		}
	}
	
	//현재 테이블 cell을 수정중인지 여부를 저장할 필드 
	boolean isEditing=false;

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("property change!");
		System.out.println(evt.getPropertyName());
		
		
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {//수정중일때 
				//변화된 값을 읽어와서 DB 에 반영한다. 
				//수정된 칼럼에 있는 row 전체의 값을 읽어온다. 
				int selectedIndex = table.getSelectedRow();
				int num=(int)model.getValueAt(selectedIndex, 0);
				String name = (String)model.getValueAt(selectedIndex, 1);
				String birthday = list.get(selectedIndex).getBirthday();
				//수정할 회원의 정보를 BirthDto 객체에 담고 
				BirthDto dto = new BirthDto(num, name, birthday);
				//DB에 저장하기 
				BirthDao.getInstance().update(dto);
				isEditing = false;//수정중이 아니라고 표시한다.
			}else {
				isEditing = true;//수정중이라 표시한다.
			}
		}
	}

	//버튼 누를 때 일어나는 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		//actionCommand 읽어오기
		String command = e.getActionCommand();
		if(command.equals("save")) {
			//저장 버튼 동작
			//1. 입력한 문자열을 읽어와서
			String name = inputNameTextField.getText();
			String birthday = inputBirthdayTextField.getText();
			
			//2. BirthDto 객체에 담아서
			BirthDto dto = new BirthDto(name, birthday);

			//3. BirthDao 객체를 이용해서 DB 에 저장
			boolean isSuccess = BirthDao.getInstance().insert(dto);
			
			//4. 성공 여부를 JOptionPane.showMessageDialog 로 팝업창 띄우기
			if(isSuccess) {
				//성공
				JOptionPane.showMessageDialog(this, "이름(" + name + "), "
													+ "생일(" + birthday + ") 추가 성공!");
			}else {
				//실패
				JOptionPane.showMessageDialog(this, "추가 실패!");
			}
			
			//*textFiled 들 비우기
			inputNameTextField.setText("");
			inputBirthdayTextField.setText("");
			
			//5. JTable 목록 다시 출력하기
			displayBirth();
			
		}else if(command.equals("delete")) {
			//삭제 버튼
			//1. 선택된 row index 읽어온다.
			//getSelectedRow() 는 선택된 row 의 inex 를 return
			//만약 선택된 row가 없다면, -1 을 return
			int selectedIndex = table.getSelectedRow();
			
			//선택된 row 가 없다면, 메소드 끝 (return)
			if(selectedIndex == -1) {
				//선택된 row 없음 -> 끝
				return;
			}
			
			//2. 실제 삭제할 것인지 확인 - JOptionPane.showConfirmDialog 사용
			int selection = JOptionPane.showConfirmDialog(this, "선택된 row 를 삭제하겠습니까?");
			
			//삭제 여부 확인 - yes 옵션이 아니면 끝
			if(selection != JOptionPane.YES_OPTION) {
				return;
			}
			
			//삭제한다면?
			//3. 선택된 row 의 pk 인 num 컬럼 숫자 읽어옴.
			//getValueAt 은 Object 를 return -> 형변환(casting) 필수!
			int num = (int)model.getValueAt(selectedIndex, 0);
			
			//4. 정보 삭제
			boolean isDelete = BirthDao.getInstance().delete(num);
			
			//5. 삭제가 제대로  됐는지 확인
			if(isDelete) {
				JOptionPane.showMessageDialog(this, "삭제되었습니다.");
			}else {
				JOptionPane.showMessageDialog(this, "삭제 실패");
			}
			
			//6. table 다시 출력
			displayBirth();
			
		}else if(command.equals("refresh")) {
			//새로고침 버튼 - JTable 목록 다시 출력하기
			displayBirth();
		}
		
	}
	
}



















