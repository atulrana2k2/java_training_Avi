import java.util.Scanner;

public class ncr_recursion_10
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n= sc.nextInt();
        System.out.println("Enter the value of r :");
        int r=sc.nextInt();
        int N=fact(n);
        int R=fact(r);
        int e=fact(n-r);
        System.out.println("The value of NcR is "+N/(R*e));
    }
    public static int fact(int n)
    {
        if(n==0||n==1)
            return 1;
        else
            return n*fact(n-1);
    }
}
