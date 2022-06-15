package plus;

import java.util.*;

class Sol03 {
    public static TreeSet<Integer> test03(int[] numbers) {
        TreeSet<Integer> answer = new TreeSet<Integer>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                answer.add(numbers[i] + numbers[j]);
            }
        }
        return answer ;

    }

}
