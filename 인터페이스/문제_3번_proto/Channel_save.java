package 인터페이스.문제_3번_proto;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Channel_save implements SmartTV_function {
    //채널 저장
    ArrayList<Integer> channel = new ArrayList<>();
    HashMap<Integer,ArrayList<Integer>> list = new HashMap<Integer,ArrayList<Integer>>();
    HashMap<String,HashMap<Integer,ArrayList<Integer>>> user_list = new HashMap<String,HashMap<Integer,ArrayList<Integer>>>(); 

    public void ch_save(String input_id, int input_pw, int input_ch) {
        this.channel.add(input_ch);
        this.list.put(input_pw, this.channel);
        this.user_list.put(input_id, this.list);
    }

}
