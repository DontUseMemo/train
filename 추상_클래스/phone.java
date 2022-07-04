package 추상_클래스;

public abstract class phone {
    public String owner;

    public phone(String input_owner) {
        this.owner = input_owner;
    }

    public void turnOn() {
        System.out.println("전원이 켜집니다");
    }

    public void turnOff() {
        System.out.println("전원이 꺼집니다");
    }
}
