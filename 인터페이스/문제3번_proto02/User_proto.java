package 인터페이스.문제3번_proto02;

import java.util.ArrayList;
import java.util.Scanner;

public class User_proto extends Save implements Channel_change {
    private String id;
    private int password;
    public ArrayList<Integer> channels = new ArrayList<Integer>();
    public int current_channel = 0;
    private static User_proto[] user_list = {
            new User_proto("용사",132),
            new User_proto("네이버",111)
    };

    public User_proto() {}

    private User_proto(String input_id,int input_password) {
        this.id = input_id;
        this.password = input_password;
    }

    public User_proto user_login_id() {
        User_proto user_confirm = null;
        while(true) {
            System.out.print("id를 입력해주세요 : ");
            String check_id = scan.nextLine();
            for (User_proto user : user_list) {
                if (user.id.equals(check_id)) {
                    user_confirm = user;
                    break;
                }
            } if(user_confirm != null) {
                break;
            } else {
                System.out.println("존재하지 않는 아이디입니다.");
            }
        }
        User_proto a = user_login_pw(user_confirm);
        return a;
    }

    public User_proto user_login_pw(User_proto a) {
        while(true) {
            System.out.print("비밀번호를 입력해주세요 : ");
            int input_pw = scan.nextInt();
            if (a.password == input_pw) {
                System.out.println(a.id + "님 반갑습니다.");
                break;
            } else {
                System.out.println("비밀번호를 잘못입력했습니다.");
            }
        } return a;
    }

    public void user_logout() {
        System.out.println("로그아웃합니다.");
    }


}
