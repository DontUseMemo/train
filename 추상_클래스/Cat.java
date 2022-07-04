package 추상_클래스;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("야옹");
    }

    public void behavior() {
        System.out.println("살금살금");
    }

    public void catpunch() {
        System.out.println("냐악!");
    }
}
