package 인터페이스;


import 인터페이스.문제3번_proto02.*;
import 인터페이스.문제7.*;
import 인터페이스.시험풀이.Solution02;

import java.util.ArrayList;
import java.util.Scanner;

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

//        Human Lee = new Human("망고","용식");
//        Human Park = new Human("포도","성식");
//        Human Kim = new Human("사과","상속");
//
//        Food food[] = {
//                new Candy(),
//                new Jelly(),
//                new Snack(),
//        };
//
//        Food sweets = food[0];
//
//        Kim.choice(sweets);
//        Kim.jelly_select(sweets);
//        Kim.eating(sweets);
        //-----------------------------------------
//        int[] cha = {1,2,2,2,3,3};
//        User Kim = new User("김용식",1234,cha);
//        Kim.initial_ch(Kim);
//        Kim.login();
//        Kim.ch_change(Kim);
//        Kim.ch_save(Kim);
//        Kim.ch_change(Kim);

//        User_proto user = new User_proto();
//        smartTV(user);

        Solution02 sol = new Solution02();
        sol.drive();

    }

    public static void smartTV(User_proto a) {
        int i = 0;
        while(i<6) {
            Channel_change.initial_ch(a);
            System.out.println("-----------------");
            User_proto confirmed_user = a.user_login_id();
            System.out.println("-----------------");
            a.ch_save(confirmed_user);
            System.out.println("-----------------");
            Channel_change.ch_change(confirmed_user);
            System.out.println("-----------------");
            confirmed_user.user_logout();
            System.out.println("=================\n");
            i++;
        }
    }
}
