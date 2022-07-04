package 별찍기;

public class hard {

    public static void Triangle() {
        String[][] arr = new String[30][60];
        for(int i=0; i<30; i++) {
            for(int j=0; j<60; j++) {
                arr[i][j] = "*";
            }
        }
        int z = 0;
        for(int i=10; i<20; i++) {
            for(int j=15-z; j<16+z; j++) {
                arr[i][j] = "@";
            }z++;
        }
        z=0;
        for(int i=29; i>19; i--) {
            for(int j=50-z; j<51+z; j++) {
                arr[i][j] = "#";
            }z++;
        }
        for(int i=0; i<30; i++) {
            for(int j=0; j<60; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
