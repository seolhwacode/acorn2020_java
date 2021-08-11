package test.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class BirthDto {

	//필드 지정하기
	private int num;
	private String name;
	private String birthday;
	
	//디폴트 생성자
	public BirthDto() {}

	public BirthDto(int num, String name, String birthday) {
		super();
		this.num = num;
		this.name = name;
		this.birthday = birthday;
	}
	
	//insert 할 때, num 은 sequence 로 자동으로 들어가므로,
	//그 때 name, birthday 로 객체 생성하는 생성자
	public BirthDto(String name, String birthday) {
		super();
		this.name = name;
		this.birthday = birthday;
	}

	//getter / setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return num + "/" + name + "/" + birthday;
	}
	
	public String formatBirthday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return sdf.format(Date.valueOf(birthday));
	}
}
