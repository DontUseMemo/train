package 오버라이드.unit;

public class Hero {
    public int hp = 500;
    public int att = 10;
    public String name;

    public Hero(String input_name) {
        this.name = input_name;
    }

    public void info() {
        System.out.println(this.name + "의 hp는 " + this.hp + "입니다");
    }

    //무기를 낄 때 공격력 추가
    public int attack(int weapon_add_att) {
        this.att = att + weapon_add_att;
        System.out.println(this.name + "가(이) " + att + " 만큼 공격을 했다");
        return att;
    }
    
    //데미지받았을 때
    public void dem(int input_dem) {
        int dem = input_dem;
        System.out.println(this.name + "가(이) " + dem + " 만큼 공격 받았다");
    }
}
