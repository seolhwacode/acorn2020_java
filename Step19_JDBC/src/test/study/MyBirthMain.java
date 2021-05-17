package test.study;

import java.util.List;

import test.dao.BirthDao;
import test.dto.BirthDto;

public class MyBirthMain {

	public static void main(String[] args) {
		//BirthDto, BirthDao test
		BirthDto dto = new BirthDto();
		dto.setNum(1);
		dto.setName("name2");
		dto.setBirthday("2021-05-18 11:50:30");
		
		BirthDao dao = BirthDao.getInstance();
		
		//insert
		dao.insert(dto);

		//getData
//		System.out.println(dao.getData(6).getBirth());
		
		//getList
		List<BirthDto> list = dao.getList();
		for(BirthDto dto1:list) {
			System.out.println(dto1.getBirthday());
		}
	}

}
