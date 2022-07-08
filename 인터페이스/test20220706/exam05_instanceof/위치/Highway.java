package 인터페이스.test20220706.exam05_instanceof.위치;

import 인터페이스.test20220706.exam05_instanceof.운전자.Driver;

public class Highway {
    public static void highway_entry(Driver[] driver_type,Driver input_driver) {
        System.out.println("고속도로입니다.");
        for(int i = 0; i<driver_type.length; i++) {
            if(driver_type[i].driver_level.equals("전문가")) {
                input_driver.setDriver_level(driver_type[i].getDriver_level());
                input_driver.setSpeed(driver_type[i].getSpeed());
            }
        } input_driver.running();
    }
}
