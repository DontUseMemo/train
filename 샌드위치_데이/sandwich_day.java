package 샌드위치_데이;

import java.util.ArrayList;

import 샌드위치_데이.샌드위치.*;

public class sandwich_day {
    public static void main(String[] arg) {
        sandwich01 sand1 = new sandwich01();
        sandwich02 sand2 = new sandwich02();
        sandwich03 sand3 = new sandwich03();
        sandwich04 sand4 = new sandwich04();
        sandwich05 sand5 = new sandwich05();

        ArrayList<sandwich> eatlist = new ArrayList<sandwich>(5);
        eatlist.add(new sandwich(sand1.name, sand1.add));
        eatlist.add(new sandwich(sand2.name, sand2.add));
        eatlist.add(new sandwich(sand3.name, sand3.add));
        eatlist.add(new sandwich(sand4.name, sand4.add));
        eatlist.add(new sandwich(sand5.name, sand5.add));

        String[] week = {"월요일", "화요일", "수요일", "목요일", "금요일"};

        int i = 0;
        for(sandwich sand: eatlist) {
            System.out.println(week[i] + " 점심은 " + sand.name + " 입니다");
            System.out.println("재료는 " + sand.ingredient + ", " + sand.add + " 입니다\n");
            i++;
        }
    }
}
