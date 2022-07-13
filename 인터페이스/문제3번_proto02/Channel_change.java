package 인터페이스.문제3번_proto02;

import java.util.Scanner;

public interface Channel_change extends Favorite_ch {
    static void initial_ch(User_proto a) {
        System.out.println("기본 채널을 틉니다");
        a.current_channel = default_channel;
        System.out.println("현재 채널 : " + a.current_channel);
    }
    static void ch_change(User_proto a) {
        a.current_channel = Favorite_ch.ch_check(a);
        System.out.println("현재 채널 : " + a.current_channel);
    }
}
