package test;

public class Student {
	private Bell bell ;
	public void setBell(Bell bell) {
		this.bell = bell;
	}
	public void study1() {
		bell.startBell();
		System.out.println("1���ô� ����ð��Դϴ�");
		
	}

	public void study2() {
		
		System.out.println("2���ô� ����ð��Դϴ�");
		
	}

	public void study3() {
		
		System.out.println("3���ô� �����ð��Դϴ�");
		
	}

	public void study4() {
		
		System.out.println("4���ô� ���нð��Դϴ�");
		
	}
}
