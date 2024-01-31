import java.util.Scanner;

public class patternj7 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number :");
        int n=sc.nextInt();
        for(int i=n;i>=1;i--)
        {
            for(int x=1;x<i;x++)
                System.out.print(" ");
            for(int j=1;j<=n-i+1;j++)
                System.out.print(j);
            System.out.println();
        }

    }
}
