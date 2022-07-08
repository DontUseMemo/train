package 인터페이스.문제3번_진짜_제발;


public interface Favorite_ch {

    int default_channel = 5;

    static int ch_check(User a) {
        int answer = 0;
        int[] index = new int[a.channels.size()+1];
        int max = Integer.MIN_VALUE;

        for (int j : a.channels) {
            index[j]++;
        }

        for(int i=0; i<index.length; i++) {
            if(index[i]>max) {
                max = index[i];
                answer = i;
            }
        } System.out.println("선호 채널은 " + answer + "번 입니다");
        return answer;
    }
}
