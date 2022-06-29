package 다형성;

public class Main {
    public static void main(String[] arg) {
        Parent parent = new Parent();
        Child child = new Child();

        parent.test(child);
    }
}
