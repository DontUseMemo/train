package 인터페이스.test20220706.exam05_instanceof;

public class Bus implements Vehicle, Hi_pass {
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
	
	public void checkFare() {
		System.out.println(" ");
	}

	@Override
	public void pass_system() {
		System.out.println("하이패스 사용 제외대상입니다.");
	}
}
