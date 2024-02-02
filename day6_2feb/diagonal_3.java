import java.util.ArrayList;
import java.util.Scanner;

public class diagonal_3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        System.out.println("Enter the number of rows :");
        int n = sc.nextInt();
        System.out.println("Enter the number of columns :");
        int m = sc.nextInt();
        int[][] array = new int[n][m];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
            {
                System.out.print(array[j][j+i]+" ");

        }
            m--;
            System.out.println();
    }
}}