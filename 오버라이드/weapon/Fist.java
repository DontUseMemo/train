package 오버라이드.weapon;

public class Fist {
    public static final String defalt_name = "주먹";
    public static final int defalt_AttRange = 1;
    public static final int defalt_ChangeTime = 4;
    public static final int defalt_add_att = 0;


    public String name = defalt_name;
    public int AttRange = defalt_AttRange;
    public int ChangeTime = defalt_ChangeTime;
    public int add_att = defalt_add_att;

    public Fist() {}

    //무기를 장착했을 때
    public void chooseWeapon() {
        System.out.println(name + " 공격을 합니다");
        System.out.println(ChangeTime + "턴 이후 무기를 장착할 수 있습니다");
    }

    //무기로 행동
    public void attAction() {
        System.out.println(name + " 공격!");
    }

    //무기 장착을 해제했을 때
    public void changeWeapon() {
        System.out.println(name + " 공격이 끝났습니다\n새로운 무기로 교체합니다");
    }
}
