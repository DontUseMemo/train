package 추상_클래스;

public class Main {
    public static void main(String[] arg) {
        
        //형변환없이 자식 클래스를 불러온 경우
        smartphone galaxy = new smartphone("김용식");

        galaxy.turnOn();
        galaxy.turnOff();
        galaxy.internetSearch();
        System.out.println("");

        phone LG = new smartphone("이용직");

        //형 변환 후 자식 클래스를 불러온 경우
        smartphone apple = new smartphone("이용식");
        phone not_smartphone = (phone) apple;

        not_smartphone.turnOn();
        not_smartphone.turnOff();
        // not_smartphone.internetSearch();
        System.out.println("");

        //다시 자식 클래스로 형변환
        smartphone again_smartphone = (smartphone) not_smartphone;
        again_smartphone.internetSearch();
        sound(again_smartphone);   
    }

    public static void sound(phone name) {
        name.turnOn();
    }
}
