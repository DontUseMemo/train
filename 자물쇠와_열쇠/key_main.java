package 자물쇠와_열쇠;

public class key_main {
    public static void main(String[] arg) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Solution01.solution(key,lock);
    }
}
