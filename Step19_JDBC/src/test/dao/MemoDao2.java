package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemoDto2;
import test.util.DBConnect;

public class MemoDao2 {
	private static MemoDao2 dao;
	
	private MemoDao2() {}
	
	public static MemoDao2 getInstance() {
		if(dao == null) dao = new MemoDao2();
		return dao;
	}
	
	//pk를 받아와서 해당하는 row 가져오기
	public MemoDto2 getData(int num) {

		//return 할 DTO 객체
		MemoDto2 dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "SELECT * FROM memo"
					+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다.
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다.
				dto = new MemoDto2();
				
				dto.setNum(rs.getInt("num"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		//여기서 return 해줘야 모든 곳에서 return 해야하는 조건이 만족된다.
		return dto;
	}
	
	//memo 테이블의 모든 row 가져오기
	//select 문 기본 형태 - templates 에 저장 : 
	public List<MemoDto2> getList() {

		//Dto 를 생성할 변수 생성 - 잠시 담는 역할만 할 것
		MemoDto2 dto = null;
		//Dto list
		List<MemoDto2> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "SELECT * FROM memo"
					+ " ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다.

			rs = pstmt.executeQuery();
			while (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다.
				dto = new MemoDto2();
				dto.setNum(rs.getInt("num"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
	
	//insert
	public boolean insert(MemoDto2 dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//상황에 맞는 sql 문 작성
			String sql = "INSERT INTO memo"
					+ " (num, content, regdate)"
					+ " VALUES(memo_seq.NEXTVAL, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있다면 여기서 수행한다.
			pstmt.setString(1, dto.getContent());
			pstmt.setDate(2, Date.valueOf(dto.getRegdate()));

			//select문 실행 - 결과 flag 로 변경사항이 있는(수정, 추가, 삭제) row 의 개수 return
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		}
		//flag 에 성공 여부 판단
		if (flag > 0) {//성공
			return true;
		} else {//실패
			return false;
		}
	}
	
	//update : pk num 을 읽어서 그 안의 content 를 수정
	public boolean update(MemoDto2 dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//상황에 맞는 sql 문 작성
			String sql = "UPDATE memo"
					+ " SET content = ?"
					+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있다면 여기서 수행한다.
			pstmt.setString(1, dto.getContent());
			pstmt.setInt(2, dto.getNum());

			//select문 실행 - 결과 flag 로 변경사항이 있는(수정, 추가, 삭제) row 의 개수 return
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		//flag 에 성공 여부 판단
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//delete : pk num 을 읽어서, 해당 row 를 삭제
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//상황에 맞는 sql 문 작성
			String sql = "DELETE FROM memo"
					+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있다면 여기서 수행한다.
			pstmt.setInt(1, num);

			//select문 실행 - 결과 flag 로 변경사항이 있는(수정, 추가, 삭제) row 의 개수 return
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		//flag 에 성공 여부 판단
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
