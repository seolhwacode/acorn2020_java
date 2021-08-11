package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.BirthDto;
import test.util.DBConnect;

public class BirthDao {

	//2. 자신의 참조값을 저장할 static 필드 정의
	private static BirthDao dao;
	
	//1. 외부에서 객체 생성하지 못하도록
	private BirthDao() {}
	
	//3. 자신의 참조값을 리턴해주는 공개 static method
	public static BirthDao getInstance() {
		//dao 객체가 최초 호출 될 때는 null 이므로, 객체 생성
		//클래스 안에서는 private 접근 지정자로 된 생성자 호출 가능
		if(dao == null) dao = new BirthDao();
		return dao;
	}
	
	//생일 정보를 저장하는 메소드 (작업 성공 여부는 boolean 으로 리턴)
	public boolean insert(BirthDto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//상황에 맞는 sql 문 작성
			String sql = "INSERT INTO birth"
					+ " (num, name, birthday)"
					+ " VALUES(birth_seq.NEXTVAL, ?, TO_DATE(?,'YYYY-MM-DD'))";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있다면 여기서 수행한다.
			
			//1번째 ? 에 BirthDto 객체에 있는 이름을 불러와서 바인딩
			pstmt.setString(1, dto.getName());
			//2번째 ? 에 BirthDto 객체에 있는 생일을 불러와서 바인딩 
			pstmt.setString(2, dto.getBirthday());
			
			//select문 실행 - 결과 flag 로 변경사항이 있는(수정, 추가, 삭제) row 의 개수 return
			//PreparedStatement 객체의 메소드를 이용해서 sql 문을 실행하고 수정된 row 의 갯수를 리턴한다.
			//1 개의 row 가 추가 되었으므로 1 을 리턴하게 된다. 
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
		//flag 에 성공 여부 판단 : 0보다 크면 작업 성공
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//생일 정보를 수정하는 메소드(
	public boolean update(BirthDto dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//상황에 맞는 sql 문 작성
			String sql = "UPDATE birth"
					+ " SET name = ?, birthday = TO_DATE(?,'YYYY-MM-DD')"
					+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 바인딩 할 내용이 있다면 여기서 수행한다.
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirthday());
			pstmt.setInt(3, dto.getNum());
			
			System.out.println(dto);
			
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
	
	//생일 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			//상황에 맞는 sql 문 작성
			String sql = "DELETE FROM birth"
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
	
	//한 명의 생일 정보를 리턴하는 메소드
	public BirthDto getData(int num) {

		//BirthDto 객체의 참조값을 담을 지역 변수 선언
		BirthDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "SELECT name, TO_CHAR(birthday, 'YYYY-MM-DD') AS birthday"
					+ " FROM birth"
					+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다.
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			//한 번 실행하기 때문에 if 를 사용한다.
			if (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다. 
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				//미리 만들어진 BirthDto 변수 dto 에 새로운 BirthDto 객체를 생성한다.
				dto = new BirthDto(num, name, birthday);
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
		//BirthDto 객체의 참조값을 입력한다.
		return dto;
	}
	
	//모든 생일 정보를 리턴하는 메소드
	public List<BirthDto> getList(){
		
		//return 할 List 변수 생성
		List<BirthDto> list = new ArrayList<BirthDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			//실행할 SELECT 문
			String sql = "SELECT num, name, TO_CHAR(birthday, 'YYYY-MM-DD') AS birthday"
					+ " FROM birth"
					+ " ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용은 여기서 바인딩한다.

			rs = pstmt.executeQuery();
			while (rs.next()) {
				//SELECT 된 결과를 여기서 추출해서 객체에 담는다. 
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				//BirthDto 객체에 한 명의 생일 정보를 담고
				BirthDto dto = new BirthDto(num, name, birthday);
				//List에 누적시킨다.
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
		//List<BirthDto> 리턴
		return list;
	}
	
	
	
	
	
	
	
	
	
}
