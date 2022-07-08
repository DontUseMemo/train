package 인터페이스.test20220706.exam04_casting;

public class VehicleExample {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();

		vehicle.run();
		//vehicle.checkFare();

		Bus bus = (Bus) vehicle;  //

		bus.run();
		bus.checkFare();
	}
}
