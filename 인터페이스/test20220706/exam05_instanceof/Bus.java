package 인터페이스.test20220706.exam05_instanceof;

public class Bus implements Vehicle, Pay_bills {
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
	
	public void checkFare() {
		System.out.println(" ");
	}

}
