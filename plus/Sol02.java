package plus;

import java.util.*;

class Sol02 {
    public static int[] test02(int[] numbers) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0; i<numbers.length-1; i++) {
            for(int a=1+i; a<numbers.length; a++) {
                int sum = numbers[i] + numbers[a];
                if(arr.indexOf(sum) < 0) {
                    arr.add(sum);
                }
            }
        }
        int[] answer = new int[arr.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = arr.get(i);
        }
        Arrays.sort(answer);
        return (answer);

    }
}
