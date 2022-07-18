package 인터페이스.익명중첩클래스;

public class Main {
    public static void main(String[] arg) {
        Annonymous annonymous = new Annonymous();
        annonymous.method1();
        annonymous.person.wake();
        System.out.println("------");
        annonymous.method2(2);


    }
}
