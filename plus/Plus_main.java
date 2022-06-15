package plus;

import java.util.Arrays;

public class Plus_main {
    public static void main(String[] arg){
        int[] num = {2, 1, 3, 4, 1, 5, 7, 1};
        // numbers[0] =2;
        // numbers[1] =1;
        // numbers[2] =3;
        // numbers[3] =4;
        // numbers[4] =1;
        // System.out.println(Solution(numbers));
        Sol01 first = new Sol01();
        int[] numbers = first.test01(num);
        
        // int[] numbers = Sol02.test02(num);
        
        System.out.println(Arrays.toString(numbers));
    }
}