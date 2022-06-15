package 소수_구하기;

import java.util.ArrayList;

class Solution01 {
    public static int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> sum = new ArrayList<Integer>();
        for(int i=0; i<nums.length-2; i++) {
            for(int a=i+1; a<nums.length-1; a++) {
                for (int b=a+1; b<nums.length; b++) {
                    sum.add(nums[i] + nums[a] + nums[b]);
                }  
            }
        }
        int[] list = new int[sum.size()];
        int i = 0;
        for(int num : sum) {
            list[i++] = num;
        }
        int count = 0;
        for(i=0; i<list.length; i++) {
            for(int a=1; a<=list[i]; a++) {
                if(list[i]%a==0) {
                    count++;
                }
            }
            if(count==2) {
                answer++;
            }
            count = 0;
        }
        return answer;
    }
}
