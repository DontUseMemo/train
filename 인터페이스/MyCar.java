package 인터페이스;

public class MyCar implements CarTest, Fuel {

    public void startTheCar() {
        System.out.println("시동을 켭니다");
    }

    public void turnOfftheEngine() {
        System.out.println("시동을 끕니다");
    }

    public void lackOfFuel() {
        System.out.println("연료가 부족합니다");
    }

    @Override
    public void soundEffect(int speed) {
        if(max_speed == speed) {
            System.out.println("최고속도에 도달했습니다");
        }
        else if(max_speed <= speed) {
            System.out.println("최고속도 이상으로 달릴 수 없습니다");
        }
        else {
            System.out.println("적당한 속도입니다");
        }
    }
    
    public void contro() {
        
    }
}
