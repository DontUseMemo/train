package 자물쇠와_열쇠;

public class Solution01 {
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        //이동 방향 지시
        int[] dir_x = {-1, 1, 0, 0}; // L R U D
        int[] dir_y = {0, 0, -1, 1};
        int x = 0;
        int y = 0;
        return answer;
    }

    //회전
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