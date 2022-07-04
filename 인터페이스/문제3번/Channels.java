package 인터페이스.문제3번;

import java.util.ArrayList;

public class Channels {
    public ArrayList<Integer> choose_ch = new ArrayList<>();

    public void ch_list_add(int input_ch) {
        this.choose_ch.add(input_ch);
        System.out.println(input_ch + "번 채널 입니다.");
    }
}
