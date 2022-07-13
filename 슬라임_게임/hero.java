package 슬라임_게임;

public class hero {
    public int hp;
    public int mp;

    // public hero(){
    //     hp = 10;
    //     mp = 10;
    // } 

    public hero(int input_hp, int input_mp) {
        this.hp = input_hp;
        this.mp = input_mp;
    }

    public void attack() {
        System.out.println("용사가 그냥 공격을 했다!");
    } 

    public void attack_1() {
        System.out.println("용사가 스킬 공격을 했다!");
    } 

}
