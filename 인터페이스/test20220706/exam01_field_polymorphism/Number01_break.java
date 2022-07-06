package 인터페이스.test20220706.exam01_field_polymorphism;

public class Number01_break implements brake , Pedal {

    public void stop(){
        System.out.println("Number01 브레이크");
    }

    public void push(){
        System.out.println("Number01  패발 실행");
    }

}
