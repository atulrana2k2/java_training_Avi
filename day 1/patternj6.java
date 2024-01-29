import java.util.Scanner;

public class patternj6 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number :");
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int z=0;z<i;z++)
                System.out.print(" ");
            for(int j=0;j<3;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
