package 인터페이스.문제_3번_proto;

import java.util.ArrayList;
import java.util.Arrays;

public interface SmartTV_function {

    void login(String input_id, int input_pw);
    void logout();

    default void favoirte_ch(ArrayList<Integer> input_ch) {
        int[] arr = new int[input_ch.size()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = input_ch.get(i);
        }
        Arrays.sort(arr);
    }

    static void turnOn() {
        System.out.println("스마트티비를 켭니다.");
    }
    static void turnOff(){
        System.out.println("스마트티비를 끕니다.");
    }
}
