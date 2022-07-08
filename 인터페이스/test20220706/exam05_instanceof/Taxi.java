package 인터페이스.test20220706.exam05_instanceof;

public class Taxi implements Vehicle, Hi_pass {
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}

	@Override
	public void pass_system() {
		System.out.println("하이패스 사용 대상입니다.");
		payment();
	}
}
