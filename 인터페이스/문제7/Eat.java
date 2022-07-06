package 인터페이스.문제7;

public interface Eat {
    default void eating(Food a) {
        if(a instanceof Candy) {
            System.out.println("캔디를 먹습니다.");
        } else if (a instanceof Snack) {
            System.out.println("과자를 먹습니다.");
        } else if (a instanceof Jelly) {
            System.out.println("젤리를 먹습니다.");
        }
    }

}
