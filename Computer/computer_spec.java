package Computer;

public class computer_spec {
    public String computerOS;
    public String cpuName;
    public int ramName;
    public int ssdName;

    // public computer_spec() {
    //     System.out.println("사양을 입력해주세요");
    // }

    public computer_spec(String input_cpuName, int input_ramName, int input_ssdName) {
        this.cpuName = input_cpuName;
        this.ramName = input_ramName;
        this.ssdName = input_ssdName;
    }
}
