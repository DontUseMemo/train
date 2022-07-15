package example_20220701_multi_implement;

public interface RemoteControl {

	//상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);

	//default 메소드는 인스턴스 없이 인터페이스 단독으로 사용 못함
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("소리를 끕니다");
		} else {
			System.out.println("소리를 켭니다");
		}
	}
	
	//스테틱은 인터페이스 단독으로 사용 가능
	static void changeBattery() {
		System.out.println("배터리를 교체해주세요");
	}
}
