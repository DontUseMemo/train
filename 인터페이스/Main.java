package 인터페이스;


import 인터페이스.test20220706.exam01_field_polymorphism.*;
import 인터페이스.문제7.*;

public class Main {
    public static void main(String[] arg) {
        // MyCar mycar = new MyCar();

        // CarTest car01 = mycar;
        // Fuel car02 = mycar;

        // mycar.soundEffect(60);

        // SmartTelevision tv = new SmartTelevision();
        // tv.channel_change(100);

//        TV_function.turnOn();
//        SmartTV TV = new SmartTV();
//        int[] channels = {1,1,2,2,2,3};
//        TV.new_user_save("김용사", 1234, channels);
//        TV.login();
//        TV.favoirte_ch(TV.channel);
//        TV.ch_save();

//        Car myCar = new Car();
//
//        myCar.run();
//
//        System.out.println("------check001---------");
//
//        //객체를 바꾼다
//        myCar.frontLeftTire = new KumhoTire();
//        myCar.frontRightTire = new KumhoTire();
//
//        myCar.run();
//
//        System.out.println("------check002---------");
//
//        myCar.tires[0] = new KumhoTire();
//        myCar.tires[1] = new KumhoTire();
//
//        myCar.run();

        Human me = new Human("망고","용식");
        Human you = new Human("포도","성식");
        Human yours = new Human("사과","상속");

        Food food[] = {
                new Candy(),
                new Jelly(),
                new Snack(),
        };

        Food lunch = food[2];

        me.choice(lunch);
        me.jelly_select(lunch);
        me.eating(lunch);

    }
}
