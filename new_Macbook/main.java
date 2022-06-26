package new_Macbook;

import java.util.Scanner;
import Computer.*;

public class main {
    public static void main(String[] arg) {
        System.out.println("");
        System.out.println("제가 원하는 노트북 스펙을 맞춰보세요!");
        System.out.println("");

        while(true) {
            Scanner input = new Scanner(System.in);
            // computer_spec computer01 = new computer_spec();
            System.out.println(" ** os를 선택해주세요. **");
            System.out.println("0: windows  /  1: Mac");
            int os_num = input.nextInt();
            input.nextLine();

            if(os_num == 0) {
                System.out.println("저는 Mac이 갖고 싶어요.");
                System.out.println("-----------------------");
                continue;
            }
            else if(os_num == 1) {
                System.out.println("Mac 을 선택했습니다.");
                System.out.println("");
                System.out.println("** cpu 성능을 입력해주세요. **");
                System.out.println("1: m / 2: m1 / 3: m2");
                int cpuSpec = input.nextInt();
                cpu cpu_input = new cpu();
                cpu_input.cpu_num(cpuSpec);

                System.out.println("RAM 용량을 입력해주세요.");
                int ramSpec = input.nextInt();
        
                System.out.println("SSD 용량을 입력해주세요.");
                int ssdSpec = input.nextInt();
        
                System.out.println("CPU = " + cpuSpec + "  RAM = " + ramSpec + " GB " + "  SSD = " + ssdSpec + " GB");
                System.out.println("정답입니다!");
                break;
            }
            else {
                System.out.println("잘못된 입력입니다.");
                System.out.println("-----------------");
                break;
            }
        }

    }
}
