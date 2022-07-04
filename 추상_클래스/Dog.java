package 추상_클래스;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    public void behavior() {
        System.out.println("헥헥");
    }
}
