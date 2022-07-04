package example_20220701_multi_implement;

public class SmartTelevision implements RemoteControl, Searchable {
	private int volume;
	
	public void turnOn() {
		System.out.println("켭니다");
	}	
	public void turnOff() {
		System.out.println("끕니다");
	}
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if(volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("볼륨은 " + volume);
	}
	
	public void search(String url) {
		System.out.println(url + " 을 찾습니다");
	}
    public void channel_change(int i) {
    }
}
