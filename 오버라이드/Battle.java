package 오버라이드;

import java.util.ArrayList;

import 오버라이드.unit.*;
import 오버라이드.weapon.*;

public class Battle {
    public static void main(String[] arg) {

        //용사 생성
        Hero hero = new Hero("김용사");
        
        //용사 무기 배열
        Fist[] weapons = new Fist[4];
        weapons[0] = new Fist();
        weapons[1] = new Short_sword();
        weapons[2] = new Long_sword();
        weapons[3] = new Lanse();

        //슬라임 파티 생성
        ArrayList<Slime> slimes = new ArrayList<Slime>(3);
        slimes.add(new Slime("작은"));
        slimes.add(new Slime("큰", 200));
        slimes.add(new Slime("보스", 350));

        System.out.println(hero.name + "가(이) 적 " + slimes.size() + " 마리와 마주쳤습니다");
        
        //슬라임이나 용사가 죽을 때까지 턴제 배틀(용사 선공)
        while(true) {

            hero.info();
            for(int i=0; i<slimes.size(); i++) {
                slimes.get(i).info();
            }

            //슬라임 죽었는지 살았는지 확인
            for(int i=0; i<slimes.size(); i++) {
                if(slimes.get(i).hp <= 0) {
                    slimes.remove(i);
                }
            }
            //슬라임 전멸했는지 확인
            if(slimes.size() <= 0) {
                System.out.println("전투에서 승리했습니다");
                break;
            }

            //슬라임의 공격
            hero.dem(slimes.get(0).attack());

            //용사 죽었는지 살았는지 확인
            if(hero.hp < 0) {
                System.out.println("game over");
                break;
            }
        }
    }
}
