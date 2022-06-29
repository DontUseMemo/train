package 별찍기;

public class sqare {
    
    public static void calcSqare(int input_x,int input_y) {
        for(int i = 0; i < input_x; i++) {
            for(int j = 0; j < input_y; j++) {
                System.out.print("*");
            }System.out.println();
        }
    }

    public static void calcTriagle(int input_x,int input_y) {
        int a = 0;
        for(int i=0; i<input_y; i++) {
            for(int j=0; j<input_x; j++) {
                for( ; j<=a; j++) {
                    System.out.print("*");
                }
            }
            a++;
            System.out.println();
        }
    }

    public static void calcReverseTri(int input_x, int input_y) {
        for(int i=0; i<input_y; i++) {
            for(int j=0; j<input_x-i; j++) {
                System.out.print(" ");
            }
            for(int k=input_x-i; k<=input_x; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void calcTri(int input_x, int input_y) {
        for(int i=0; i<=input_y; i++) {
            for(int j=0; j<input_x-i; j++) {
                System.out.print(" ");
            }
            for(int k=input_x-i; k<=input_x; k++) {
                System.out.print("*");
            }
            for(int n=input_x-i; n<input_x; n++) {
                System.out.print("*");
            }
            for(int m=0; m<input_x-i; m++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void calcrhombus(int input_x, int input_y) {
        for(int i=0; i<=input_y; i++) {
            for(int j=0; j<input_x-i; j++) {
                System.out.print(" ");
            }
            for(int k=input_x-i; k<=input_x; k++) {
                System.out.print("*");
            }
            for(int n=input_x-i; n<input_x; n++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0; i<=input_y; i++) {
            for(int n=input_x-i; n<=input_x; n++) {
                System.out.print(" ");
            }
            for(int m=1; m<=input_x-i; m++) {
                System.out.print("*");
            }
            for(int j=1; j<input_x-i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void round(int input_x, int input_y) {
        for (int i = 0; i <= input_y * 2; i++) {
            for (int j = 0; j <= input_x * 2; j++) {
                //원의 중심좌표(n,n)로부터 (i,j)사이의 거리를 구함
                int d = (int) Math.sqrt((i - input_x) * (i - input_x) + (j - input_x) * (j - input_x));
                //(i,j)좌표가 (n,n)사이의 거리가 반지름의길이 이하일때  좌표를 찍는다.
                if (d <= input_x) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
