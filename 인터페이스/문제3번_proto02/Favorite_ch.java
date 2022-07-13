package 인터페이스.문제3번_proto02;


import java.lang.reflect.Array;
import java.util.Arrays;

public interface Favorite_ch {

    int default_channel = 5;

    static int ch_check(User_proto a) {
        int[] arr = new int[a.channels.size()];
        for (int i=0; i<arr.length; i++) {
            arr[i] = a.channels.get(i);
        }
        Arrays.sort(arr);
        int answer = 0;
        int[] index = new int[arr[arr.length-1]+1];
        int max = Integer.MIN_VALUE;

        for (int i : a.channels) {
            index[i]++;
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
