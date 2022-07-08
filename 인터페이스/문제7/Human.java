package 인터페이스.문제7;

public class Human extends Jelly implements Choose, Eat {

    public String name;

    public Human(String input_flavor, String input_name) {
        this.jelly_flavor = input_flavor;
        this.name = input_name;
    }

    public void jelly_select(Food a) {
        if (a instanceof Jelly) {
            System.out.println(this.name + "이가 고른 젤리맛은 " + this.jelly_flavor + "입니다.");
        }
    }
}
