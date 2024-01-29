import java.util.Scanner;

public class hwpattern2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the numbers :");
        int rows= sc.nextInt();
        int n = rows/2 +1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n-i; j++)
                System.out.print(" ");
            //for stars
            for(int j = 1; j <=2*i-1; ++j)
                System.out.print("*");
            //change the line
            System.out.println();
        }

        for(int i = n-1; i >=1; i--){
            //for spaces
            for(int j = 1; j <= n-i; j++)
                System.out.print(" ");
            // for stars
            for(int j = 1; j <= 2*i-1; j++)
                System.out.print("*");
            // change the line
            System.out.println();
        }
    }
}

