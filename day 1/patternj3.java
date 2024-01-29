import java.util.Scanner;

public class patternj3 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number :");
        int n=sc.nextInt();
        int a=65;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i+1;j++)
            {
                if(i>=j)
                System.out.print((char)a);
            }
            a++;
            System.out.println();
        }
    }
}
