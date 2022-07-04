package 인터페이스;

public interface CarTest {
    int max_speed=150;
    int speed_average=60;

    //추상 메소드
    void startTheCar();
    void turnOfftheEngine();

    //디폴트 메소드
    default void soundEffect(int speed) {
        if(speed <= max_speed) {
            System.out.println("부르릉");
        }
        else {
            System.out.println("부와왕!");
        }
    }

    default void average() {
        System.out.println("도로에선 " + speed_average + " 를 지켜야 합니다");
    }

    //정적 메소드
    static void horn() {
        System.out.println("뛰뛰빵빵");
    }
}
