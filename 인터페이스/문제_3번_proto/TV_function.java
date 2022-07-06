package 인터페이스.문제_3번_proto;

import java.util.ArrayList;

public interface TV_function {

    void login();
    void logout();

    //빈도수 높은 채널 찾기
    default void favoirte_ch(ArrayList<Integer> input_ch) {
        System.out.println("check-----------");
        System.out.println(input_ch.get(0));
        System.out.println(input_ch.get(1));
        int[] arr = new int[input_ch.size()];
        for(int i=0; i<arr.length; i++) {
            arr[i] = input_ch.get(i);
        }
        int answer = 0;
        int[] index = new int[arr.length+1];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            index[arr[i]]++;
        }

        for(int i=0; i<index.length; i++) {
            if(index[i]>max) {
                max = index[i];
                answer = i;
            }
        } System.out.println("채널 " + answer + "번을 틉니다.");
    }

    static void turnOn() {
        System.out.println("스마트티비를 켭니다.");
    }
    static void turnOff(){
        System.out.println("스마트티비를 끕니다.");
    }
}
