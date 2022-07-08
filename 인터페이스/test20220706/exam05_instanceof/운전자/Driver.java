package 인터페이스.test20220706.exam05_instanceof.운전자;

import 인터페이스.test20220706.exam05_instanceof.Bus;
import 인터페이스.test20220706.exam05_instanceof.Taxi;
import 인터페이스.test20220706.exam05_instanceof.Vehicle;

public abstract class Driver {
	public String name = "김용식";
	public int money;
	public String driver_level;
	public int speed;
	public void drive(Vehicle vehicle) {
		if(vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		} else if (vehicle instanceof Taxi) {
			Taxi taxi = (Taxi) vehicle;
		}
		vehicle.run();
	}

	public void running() {
		if(this.speed <= 60) {
			System.out.println(speed + "km 이하로 달립니다. " + driver_level + "의 속도입니다.");
		} else {
			System.out.println(speed + "km 이상으로 달립니다. " + driver_level + "의 속도입니다.");
		}
	}

	public String getDriver_level() {
		return this.driver_level;
	}
	public int getSpeed() {
		return this.speed;
	}
	public void setDriver_level(String input_level) {
		this.driver_level = input_level;
	}
	public void setSpeed(int input_speed) {
		this.speed = input_speed;
	}


}
