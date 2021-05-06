package test.mypac;

public class Windows {
	private Laptop laptop;
	private boolean isWindowsOn = false;
	
	public void on() {
		System.out.println("windows 켜기");
		this.isWindowsOn = true;
	}
	
	public void off() {
		System.out.println("windows 끄기");
		this.isWindowsOn = false;
		laptop.powerOff();
	}
	
	public void reStart() {
		System.out.println("windows 재부팅...");
		System.out.println("windows 재부팅 완료.");
	}
	
	public void setLaptop(Laptop lab) {
		this.laptop = lab;
	}
	
	
}
