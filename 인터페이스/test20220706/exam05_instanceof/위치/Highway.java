package 인터페이스.test20220706.exam05_instanceof.위치;

import 인터페이스.test20220706.exam05_instanceof.운전자.Beginner;
import 인터페이스.test20220706.exam05_instanceof.운전자.Driver;
import 인터페이스.test20220706.exam05_instanceof.운전자.Expert;
import 인터페이스.test20220706.exam05_instanceof.운전자.Intermediate;

public class Highway {
    public void highway_entry(Driver a) {
        System.out.println("고속도로에 진입합니다.");
        if(a instanceof Beginner) {
            Beginner level_change = (Beginner) a;
            Intermediate level_change01 = (Intermediate) level_change;
            Expert level = (Expert) level_change01;
            level.going();
        }
    }
}
