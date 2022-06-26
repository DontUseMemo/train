import java.util.Scanner;

import 슬라임_게임.*;

public class slime_game_main {
    private static String nextLine;

    public static void main(String[] arg) {


        //string 메모리를 적게 쓰는 법
        String input = "";

        Scanner scan = new Scanner(System.in);
        System.out.println("용사의 이름을 정해주세요");

        //키보드 입력값을 input 변수에 할당
        input = scan.nextLine();

        //용사를 만들자 //용사 객체 생성(1명)
        Warrior warrior = new Warrior(input, 1000, 5000);
        warrior.info();
        scan.nextLine();

        System.out.println("용사 " + warrior.name + " 은(는) 길을 걷고 있다...." );
        scan.nextLine();
        System.out.println("용사 " + warrior.name + " 은(는) 몬스터를 만났다!" );
        scan.nextLine();

        String input_name_1 = "노란 슬라임";
        String input_name_2 = "빨간 슬라임";
        String input_name_3 = "초록 슬라임";
        String input_name_4 = "파란 슬라임";
        int input_hp = 30;
        int input_mp = 3;

        slime slime_a = new slime(input_name_1, input_hp, input_mp);
        slime slime_b = new slime(input_name_2, input_hp, input_mp);
        slime slime_c = new slime(input_name_3, input_hp, input_mp);
        slime slime_d = new slime(input_name_4, input_hp, input_mp);

        slime[] slime_party = {slime_a, slime_b, slime_c, slime_d};

        //슬라임과 대치하는 용사 상황을 코드로 구현

        //while문 (슬라임과 용사가 열심히 반복적으로 싸우는 구역)
        while(true) {

            //텍스트 랜덤으로 입력값 받기 (랜덤함수와 아스키코드로 랜덤 출력)
            //용사는 슬라임을 공격하여, 슬라임은 죽는다.
            
            //슬라임 몬스터 생성(다수)

            //슬라임은 증식을 한다.
            slime_a.info();
            slime_b.info();
            slime_c.info();
            slime_d.info();
            scan.nextLine();

            warrior.info();
            scan.nextLine();

            System.out.println("공격을 하시겠습니까?");
            System.out.println("1 = Yes  /  2 = No");
            int select = scan.nextInt();
            scan.nextLine();
            if(select == 1) {
                System.out.println("");
                System.out.println("공격 스킬을 선택해주세요");
                System.out.println("남은 mp = " + warrior.mp);
                System.out.println("=======================");
                System.out.println("1 : 기본 공격");
                System.out.println("2 : 상단 베기 mp 10 소모");
                System.out.println("3 : 종단 베기 mp 20 소모");
                System.out.println("=======================");
                int skill = select;
                scan.nextLine();

                System.out.println("");
                System.out.println("적을 선택해주세요");
                System.out.println("=======================");
                System.out.println("1 : " + slime_a.name);
                System.out.println("2 : " + slime_b.name);
                System.out.println("3 : " + slime_c.name);
                System.out.println("4 : " + slime_d.name);
                System.out.println("=======================");
                int enemy = select;
                scan.nextLine();
                switch(select) {
                    case 1:
                        
                    case 2:
                    case 3:
                }
                scan.nextLine();
            }
            else if(select == 2) {
                System.out.println("용사는 도망칠 수 없다");
                System.out.println("전투로 다시 돌아가자");
                scan.nextLine();
                continue;
            }
            scan.nextLine();

            System.out.println("용사 " + warrior.name + " 은(는) 공격을 했다!");
            slime_b.dmg(warrior.att());
            scan.nextLine();

            warrior.dmg(slime_b.att());
            //용사의 공격(1턴)
            //슬라임의 공격(1턴)
            //if(모든 슬라임이 죽을 경우) break

        }

        
    }
}
