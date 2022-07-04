package 인터페이스.문제3번;

import java.util.Arrays;
import java.util.HashMap;

public class SmartTelevisiton implements Favorite_channel {
    HashMap<String,Channels> user_list = new HashMap<String,Channels>();
    String name;

    //티비 켜기
    public void turnOn() {
        System.out.println("스마트티비를 시작합니다.");
    }
    
    //티비 끄기
    public void turnOff() {
        System.out.println("스마트티비를 끕니다.");
    }

    //사용자 확인 후 로그인
    public void login(String input_name) {
        if(user_list.get(input_name) != null) {
            this.name = input_name;
            System.out.println(this.name + "님 환영합니다.");
        }
        else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    //로그아웃
    public void logout() {
        System.out.println("로그아웃 했습니다.");
    }

    //로그인시 선호 채널 켜기
    public void my_channel_list(HashMap<String,Channels> user_list, String input_id, Channels input_ch) {
        if(input_ch == null) {
            System.out.println("아직 선호 채널이 없습니다.\n기본 채널인 0번 채널을 켭니다.");
        }
        else {
            int[] arr = new int[input_ch.choose_ch.size()];
            for(int i=0; i<arr.length; i++) {
                arr[i] = input_ch.choose_ch.get(i);
            }
            Arrays.sort(arr);

        }
    }    
    
}
