package example_20220701_multi_implement;

public class RemoteControlExample {
	public static void main(String[] args) {
		SmartTelevision tv = new SmartTelevision();
		
		RemoteControl rc = tv;
		Searchable searchable = tv;

		rc.setMute(true);
		searchable.search("google.com");

		RemoteControl.changeBattery();
	}
}
