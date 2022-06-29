package 오버라이드.weapon;

public class Long_sword extends Fist {

    public Long_sword() {
        name = "롱소드";
        AttRange = 3;
        ChangeTime = 2;
        add_att = 15;
    }
    
    @Override
    public void chooseWeapon() {
        System.out.println(name + " 을 장착합니다");
        System.out.println(add_att + " 만큼 공격력이 증가합니다");
        System.out.println(ChangeTime + "턴 이후 장착이 해제됩니다");
    }
}
