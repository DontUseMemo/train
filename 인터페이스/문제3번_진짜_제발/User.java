package 인터페이스.문제3번_진짜_제발;

import java.util.ArrayList;
import java.util.Scanner;

public class User extends Save implements Channel_change {
    public String id;
    public int password;
    public ArrayList<Integer> channels = new ArrayList<Integer>();
    public int current_channel = 0;

    public User() {}

    public User(String input_id,int input_password, int[] input_ch) {
        this.id = input_id;
        this.password = input_password;
        for (int inputCh : input_ch) {
            this.channels.add(inputCh);
        }
    }

    public void login() {
            Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("id를 입력해주세요 : ");
            String check_id = scan.nextLine();
            if (this.id.equals(check_id)) {
                System.out.print("비밀번호를 입력해주세요 : ");
                int input_pw = scan.nextInt();
                if (this.password == input_pw) {
                    System.out.println(this.id + "님 반갑습니다.");
                    break;
                } else {
                    System.out.println("비밀번호를 잘못입력했습니다.");
                }
            } else {
                System.out.println("없는 아이디입니다.");
            }
        }
    }

}
