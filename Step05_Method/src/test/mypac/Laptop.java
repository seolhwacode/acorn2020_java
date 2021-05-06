package test.mypac;

public class Laptop {
	private Windows windows;
	private boolean isPowerOn = false;
	
	public void powerOn() {
		System.out.println("전원 켜기");
		this.isPowerOn = true;
		if(this.windows == null) {
			System.out.println("installWindows() 를 통해 windows를 설치해주세요.");
			return;
		}
		this.windows.on();
	}
	
	public void powerOff() {
		System.out.println("전원 끄기");
		this.isPowerOn = false;
	}
	
	//install 되지 않으면 err 메시지, 성공하면 성공 message
	public String installWindows() {
		if(this.windows != null) {
			//이미 window가 있을 때
			return "windows가 이미 있습니다.";
		}
		this.windows = new Windows();
		this.windows.setLaptop(this);

		return "windows 설치 완료";
	}

}
