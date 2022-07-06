package 인터페이스.문제_3번_proto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Channel_save implements TV_function {

    public class User {
        String id;
        int password;
        ArrayList<Integer> channels;

        public  User(String id, int password) {
            this.id = id;
            this.password = password;
            this.channels = new ArrayList<>();
        }
    }

    Scanner scan = new Scanner(System.in);

    //채널 저장 리스트
//    public ArrayList<Integer> channel = new ArrayList<>();
//    public HashMap<Integer,ArrayList<Integer>> list = new HashMap<Integer,ArrayList<Integer>>();
//    public HashMap<String,User> user_list = new HashMap<String,User>();
//
//    //새로운 유저 생성
//    public void new_user_save(String input_id, int input_pw, int[] input_ch) {
//        for(int i=0; i<input_ch.length; i++) {
//            User.this.channels.add(input_ch[i]);
//        }
//        this.list.put(input_pw, this.channel);
//        this.user_list.put(input_id, this.list);
//    }
//
//    //기존 유저 채널 업데이트
//    public void ch_save() {
//        scan.nextLine();
//        while(true) {
//            System.out.print("(그만하기는 n을 눌러주세요) 채널을 입력해주세요 : ");
//            String input_ch = scan.nextLine();
//            if(input_ch.equals("n")) {
//                break;
//            }
//            else {
//                this.channel.add(Integer.parseInt(input_ch));
//            }
//        }
//        this.list.replace(this.password, this.channel);
//        this.user_list.replace(this.id, this.list);
//    }
    
}
