package 자물쇠와_열쇠;

public class Solution01 {
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        return answer;
    }

    
    static int[][] rotate(int[][] arr) {
        int m = arr.length;
        int[][] rotate = new int[m][m];
        for(int i =0; i<m; i++) {
            for(int j=0; j<arr[i].length; j++) {
                rotate[i][j] = arr[m-1-j][i];
            }
        }
        return rotate;
    }
}