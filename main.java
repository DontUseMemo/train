import object_test.*;

public class main {
    public static void main(String[] arg) {
        //인스턴스 생성
        Car myCar = new Car();
        Car anotherCar = new Car();

        //인스턴스의 내용 출력
        System.out.println(": " + myCar.company);
        System.out.println(": " + myCar.model);
        System.out.println(": " + myCar.color);
        System.out.println(": " + myCar.maxSpeed);
        System.out.println(": " + myCar.speed);

        //인스턴스의 값 출력
        myCar.speed = 60;
        System.out.println("myCar : " + myCar.speed);
        System.out.println("anotherCar : " + anotherCar.speed);

        int check = myCar.speedCheck();
        System.out.println("this speed = " + check);
        System.out.println("calc speed = " + Calc.calcTest(check));
    }
}
