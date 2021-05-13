package example1;

import java.net.Socket;

public class ClientMain {
	public static void main(String[] args) {
		Socket socket=null;
		try {
			//객체 생성과 동시에 서버의 5000번 port 로 접속 요청하게 된다.
			//127.0.0.1 과 localhost 는 같은 의미이며, 자신의 컴퓨터를 가리킨다.
//			socket=new Socket("127.0.0.1", 5000);
//			socket=new Socket("localhost", 5000);
			socket=new Socket("14.63.164.99", 5000);	//강사님 ip
			System.out.println("Socket 연결 성공!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//socekt 의 null 체크를 안하면, 여기서 다시 NullPointerException 이 생긴다.
				if(socket!=null)
					socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
