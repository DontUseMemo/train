package 오버라이드.unit;

public class Slime {
    public int hp = 100;
    public int att = 30;
    public String name;

    public Slime(String input_name) {
        this.name = input_name;
    }

    public Slime(String input_name, int input_hp) {
        this.name = input_name;
        this.hp = input_hp;
    }

    public void info() {
        System.out.println(this.name + "의 hp는 " + this.hp + "입니다");
    }

    public int attack() {
        System.out.println(this.name + " 슬라임이 " + this.att + "공격을 했다");
        return this.att;
    }

    public void dem(int input_dem) {
        int dem = input_dem;
        System.out.println(this.name + " 슬라임이 " + dem + "공격을 받았다");
    }
}
