import java.util.Scanner;

public class patternj2 {
    public static void main(String[] args) {
        int a = 65;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number :");
        int n=sc.nextInt();
        for (int i = 1; i <= n; i++)
        {
            for (int j = 0 + i; j > 0; j--)
                System.out.print(j);
        System.out.println();
    }
}}