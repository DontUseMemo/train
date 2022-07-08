package 인터페이스.test20220706.exam05_instanceof.운전자;

import 인터페이스.test20220706.exam05_instanceof.Bus;
import 인터페이스.test20220706.exam05_instanceof.Taxi;
import 인터페이스.test20220706.exam05_instanceof.Vehicle;

public abstract class Driver {
	public String name;
	public int money;
	public int speed;
	public String drive_level;
	public void drive(Vehicle vehicle) {
		if(vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		} else if (vehicle instanceof Taxi) {
			Taxi taxi = (Taxi) vehicle;
		}
		vehicle.run();
	}
	public void going() {
		System.out.println(drive_level + " 입니다. " + speed + "km 이하로 달립니다.");
	}
}
