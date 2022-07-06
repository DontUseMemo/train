package 인터페이스.test20220706.exam01_field_polymorphism;

public class Number02_break implements brake, Pedal {
    public void push(){
        System.out.println("num2 패달");
    }
    public void stop(){
        System.out.println("num2 브레이크");
    }

}
