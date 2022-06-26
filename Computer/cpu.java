package Computer;

public class cpu {
    public String cpu_num(int cpu_input) {
        String answer = "";
        if(cpu_input == 1) {
            System.out.println("사양이 너무 낮습니다.");
        }
        else if(cpu_input == 2) {
            answer = "m1";
        }
        else if(cpu_input == 3) {
            answer = "m2";
        }
        return answer;
    }
}
