package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass14 {
	public static void main(String[] args) {
		File memoFile=new File("c:/acorn202104/myFolder/memo.txt");
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재 하지 않습니다.");
				return; //메소드 끝내기 
			}
			//파일에서 문자열을 읽어들일 객체
			FileReader fr = new FileReader(memoFile);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				//readLine() 파일에서 한 줄, 즉 개행문자까지 읽어오는 함수
				//개행문자는 읽어오지 않는다.
				//파일의 끝에 더이상 읽을 라인이 없다면, null 을 리턴
				String line = br.readLine();
				//읽을 문자열이 없으면 반복문 탈출
				if(line == null) break;
				System.out.println(line);
			}
			
			if(br != null) br.close();
			if(fr != null) fr.close();
//			FileReader fr=new FileReader(memoFile);
//			BufferedReader br=new BufferedReader(fr);
//			while(true) {
//				//반복문 돌면서 문자열을 줄단위로(개행기호 기준) 읽어낸다.
//				String line=br.readLine();
//				if(line==null) {//더이상 읽을 문자열이 없으면
//					break;//반복문 탈출
//				}
//				//읽은 문자열 출력하기 
//				System.out.println(line);
//			}
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}




