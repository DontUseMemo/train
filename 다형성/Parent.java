package 다형성;

public class Parent {
    String name;

    public void Action() {
        System.out.println("이건 부모 클래스 메소드란다");
    }

    public void test(Parent input) {
        input.Action();
        System.out.println("어떤 메소드가 나왔습니까?");
    }
}
