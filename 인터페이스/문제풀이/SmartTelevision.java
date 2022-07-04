package 인터페이스.문제풀이;

public class SmartTelevision implements Searchable {

    public void channel_change(int input_ch) {
        if(input_ch <= 14) {
            System.out.println("채널: " + channel01);
        }
        else if(15<input_ch && input_ch <=22) {
            System.out.println("채널: " + channel02);
        }
        else if(23<input_ch && input_ch <= 25+(120-25)/2) {
            System.out.println("채널: " + channel03);
        }
        else {
            System.out.println("채널: " + channel04);
        }
    }
}
