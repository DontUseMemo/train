package 인터페이스.시험풀이;

import java.util.Scanner;

public class Solution02 {
    public Scanner scan = new Scanner(System.in);
    public String[] driver = {"김용식", "강희현", "데이비드", "이휘혈"};

    public void driver_list() {
        String first_driver = driver[0];
        System.out.println(first_driver + " 이 운전자는 달릴 수 없습니다.");
    }

    public void drive() {
        for(int i = 0; i<2; i++) {
            String car_dr = driver[i];
            System.out.println(i + "번째 :" + car_dr + "\n");
        }
    }
}
