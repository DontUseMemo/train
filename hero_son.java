public class hero_son extends hero {
    public int hunger;

    public hero_son(int input_hp, int input_mp, int input_hunger) {
        super(input_hp, input_mp);
        this.hunger = input_hunger;
    }

    public void hungry() {
        System.out.println("용사는 배가 고파졌다");
    }
}
