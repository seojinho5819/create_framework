package test;

public class Student {
	private Bell bell ;
	public void setBell(Bell bell) {
		this.bell = bell;
	}
	public void study1() {
		bell.startBell();
		System.out.println("1교시는 영어시간입니다");
		
	}

	public void study2() {
		
		System.out.println("2교시는 국어시간입니다");
		
	}

	public void study3() {
		
		System.out.println("3교시는 물리시간입니다");
		
	}

	public void study4() {
		
		System.out.println("4교시는 수학시간입니다");
		
	}
}
