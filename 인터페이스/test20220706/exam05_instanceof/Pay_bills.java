package 인터페이스.test20220706.exam05_instanceof;

public interface Pay_bills {
    default void payment() {
        System.out.println("요금을 계산합니다.");
    }
}
