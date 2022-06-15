package plus;

import java.util.*;

class Sol01 {
    public int[] test01(int[] numbers) {
        HashSet<Integer> arr = new HashSet<Integer>();

        for(int i=0; i<numbers.length-1; i++) {
            for(int a=1+i; a<numbers.length; a++) {
                arr.add(numbers[i] + numbers[a]);
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>(arr);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        //ArrayList 를 쓰지 않을 때
        //get() 메소드를 쓸 수 없을 때
        //for each문
        // int i = 0;
        // for(int num : arr) {
        //     answer[i++] = num
        // }
        Arrays.sort(answer);

        // @Override
        // public String toString() {
            return (answer);
        // }
    }
}
