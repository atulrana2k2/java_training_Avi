import java.util.Scanner;

public class hw6 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number :");
        int n = sc.nextInt();
        int temp=n;
        int rev=0;
        while(temp>0)
        {
            int rem=temp%10;
            rev=rev*10+rem;
            temp/=10;

        }
        if(rev==n)
            System.out.println("The entered number "+ n+" is PALINDROME");
        else
            System.out.println("The entered number "+ n+" is not PALINDROME");

    }
}
