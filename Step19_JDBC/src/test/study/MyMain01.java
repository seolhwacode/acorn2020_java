package test.study;

import java.util.List;

import test.dao.MemoDao2;
import test.dto.MemoDto2;

public class MyMain01 {

	public static void main(String[] args) {
		//MemoDat2, MemoDto test
		MemoDao2 dao = MemoDao2.getInstance();
		
		//더하기
		MemoDto2 dto1 = new MemoDto2();
		dto1.setNum(3);
		dto1.setContent("test5");
		dto1.setRegdate("2021-05-20");
		
		//insert
//		dao.insert(dto1);
		
		//getData
//		dto1 = dao.getData(1);
//		System.out.println(dto1);
		
		//update
//		dao.update(dto1);
		
		//delete 
//		dao.delete(3);
		
		//getList
		List<MemoDto2> list = dao.getList();
		for(MemoDto2 dto:list) {
			System.out.println(dto);
		}
	}

}
