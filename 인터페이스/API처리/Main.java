package 인터페이스.API처리;

public class Main {
    public static void main(String[] arg) {
        Student student01 = new Student("최성식",2);
        boolean compare = student01.equals(new Student("최성식",1));
        same_student(compare);
    }

    static void same_student(boolean a) {
        if(a) {
            System.out.println("같은 사람입니다.");
        } else {
            System.out.println("다른 사람입니다.");
        }
    }
}
