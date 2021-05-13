package test.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass13 {
	public static void main(String[] args) {
		File memoFile=new File("c:/acorn202104/myFolder/memo.txt");
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재 하지 않습니다.");
				return; //메소드 끝내기 
			}
			//파일에서 문자열을 읽어들일 객체
			FileReader fr = new FileReader(memoFile);
			/*
			 * memo.txt 파일에 몇개의 문자가 있는지 잘 모름
			 * 아래 3줄의 코드를 memo.txt 파일에 있는 모든 문자를 읽어올 때까지 반복수행하고 싶음
			 */
			//code 값이 -1이 될 때까지 (파일이 끝날 때까지) 반복 수행
			while(true) {
				int code = fr.read();	//한 문자를 읽어온다. -> int 값으로 가져온다.
				//.read() 메소드는 읽은 한 문자값을 int로 return 한다. 파일의 끝이 되면 -1 을 return
				//-1 이면 파일을 다 읽었다는 뜻이므로, break 로 반복문을 빠져나간다.
				if(code == -1) break;
				char ch = (char)code;	//int 값으로 가져온 문자를 char 형으로 형변환
				System.out.print(ch);	//출력
			}
			
//			FileReader fr=new FileReader(memoFile);
//			while(true) {
//				//글자 하나 하나의 코드값을 반복문 돌면서 읽어들인다. 
//				int code=fr.read();
//				if(code==-1) {//더이상 읽을 코드가 없으면 
//					break;//반복문 탈출 
//				}
//				//코드값에 해당되는 문자
//				char ch=(char)code;
//				//콘솔창에 개행기호 없이 한글자 한글자 출력하기
//				System.out.print(ch);
//			}
		}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
}




