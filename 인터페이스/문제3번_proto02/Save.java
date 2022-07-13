package 인터페이스.문제3번_proto02;


import java.util.Scanner;

public abstract class Save {
    public Scanner scan = new Scanner(System.in);

    public void ch_save(User_proto a) {
        try{
            scan.nextLine();
            while(true) {
                System.out.print("(그만하기: 아무키나 눌러주세요) 채널을 입력해주세요 : ");
                String input_ch = scan.nextLine();
                if(input_ch.equals("n")) {
                    System.out.println("채널 저장을 그만둡니다.");
                    System.out.println(a.channels);
                    break;
                } else {
                    a.channels.add(Integer.parseInt(input_ch));
                }
            }
        } catch(NumberFormatException e) {
            System.out.println("채널 저장을 그만둡니다.");
            System.out.println(a.channels);
        }
    }
}
