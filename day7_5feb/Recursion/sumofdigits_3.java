import java.util.Scanner;

public class sumofdigits_3 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number :");
        int n= sc.nextInt();
        int ans = countd(n);
        System.out.println(ans);
    }
    public static int  countd(int n)
    {
        if(n==0)
            return n%10;
        else
            return n%10+countd(n/10);
    }
}
