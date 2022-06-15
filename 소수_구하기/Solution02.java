package 소수_구하기;

class Solution02 {
    public static int solution (int[] nums) {
        int answer = 0;
        int sum = 0;
        int count = 0;
        for (int i=0; i<nums.length-2; i++) {
            for (int a=i+1; a<nums.length-1; a++) {
                for (int b=a+1; b<nums.length; b++) {
                    sum = nums[i] + nums[a] + nums[b];
                    for (int j=1; j<=sum; j++) {
                        if (sum%j==0) {
                            count++;
                        }
                    }
                    if(count==2) {
                        answer++;
                    }
                    count = 0;
                }
            }
        }
        return answer;
    }

}
