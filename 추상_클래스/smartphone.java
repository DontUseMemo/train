package 추상_클래스;

public class smartphone extends phone {
    public smartphone(String input_owner) {
        super(input_owner);
    }
    
    @Override
    public void turnOn() {
        System.out.println("스마트폰을 시작합니다");
    }

    public void internetSearch() {
        System.out.println("인터넷을 켭니다");
    }
}
