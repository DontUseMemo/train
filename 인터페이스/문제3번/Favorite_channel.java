package 인터페이스.문제3번;

import java.util.HashMap;

public interface Favorite_channel {

    void turnOn();
    void turnOff();
    void login(String input_name);
    void logout();
    
    //채널 저장
    default void ch_save(HashMap<String,Channels> user_list, String input_id, Channels input_ch) {
        user_list.put(input_id, input_ch);
    }

}
