package 인터페이스.test20220706.exam05_instanceof.운전자;

public class Expert extends Intermediate {
    public Expert() {
        speed = 100;
        drive_level = "전문가";
    }

    @Override
    public void going() {
        System.out.println(drive_level + " 입니다. " + speed + "km 이상으로 달립니다.");
    }
}
