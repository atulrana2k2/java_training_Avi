import java.util.Scanner;

public class patternj1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number :");
        int n=sc.nextInt();
        int a = 65;
        for (int i = 1; i <= n; i++) {
            for (int j = 64 + i; j <64 + 2 * i; j++) {
                System.out.print((char) j);
            }
            System.out.println();
        }
    }
}