package 오버라이드.weapon;

public class Short_sword extends Fist {
    
    public Short_sword() {
        name = "숏소드";
        AttRange = 2;
        ChangeTime = 3;
        add_att = 10;
    }

    @Override
    public void chooseWeapon() {
        System.out.println(name + " 을 장착합니다");
        System.out.println(add_att + " 만큼 공격력이 증가합니다");
        System.out.println(ChangeTime + "턴 이후 장착이 해제됩니다");
    }

}
