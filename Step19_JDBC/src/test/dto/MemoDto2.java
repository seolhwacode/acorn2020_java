package test.dto;

import java.sql.Date;

public class MemoDto2 {
	//테이블 구조
	private int num;
	private String content;
	private String regdate;
	
	//생성자
	public MemoDto2() {
		super();
	}

	public MemoDto2(String content, String regdate) {
		super();
		this.content = content;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return num + " / " + content +" / " + regdate;
	}
}
