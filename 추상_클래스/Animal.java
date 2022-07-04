package 추상_클래스;

public abstract class Animal {
    public String owner;

    public Animal(String name) {
        this.owner = name;
    }

    public void sound() {
        System.out.println("랄라");
    }

    public void behavior() {
        System.out.println("어슬렁");
    }
}
