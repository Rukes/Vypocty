import java.util.Random;

public class DimensionalArray {

    public static void main(String[] args) {
        int[][] a = new int[7][8];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = r.nextInt(100);
            }
        }

        for(int i = 0; i < a.length; i++){
            StringBuilder row = new StringBuilder();
            int max = a[i][0];
            int count = 0;
            for(int j = 0; j < a[i].length; j++){
                count += a[i][j];
                if(a[i][j] > max){
                    max = a[i][j];
                }
                row.append(a[i][j]).append(" + ");
            }
            System.out.println(row.toString().substring(0, row.length() - 2) + "= " + count + " (max: " + max+")");
        }
    }
}
