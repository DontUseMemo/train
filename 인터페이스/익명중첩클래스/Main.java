package 인터페이스.익명중첩클래스;

public class Main {
    public static void main(String[] arg) {
        Annonymous annonymous = new Annonymous();
        annonymous.method1();
        annonymous.person.wake();
        System.out.println("------");
        annonymous.method2(2);
        annonymous.method3(
            new Person() {
                @Override
                public void wake() {
                    System.out.println("오늘은 늦게 일어나도되니까 12시에 일어나야지!");
                }
        });
    }
}
