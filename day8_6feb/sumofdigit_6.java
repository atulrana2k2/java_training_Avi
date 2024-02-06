import java.util.Scanner;

public class sumofdigit_6 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n= sc.nextInt();
        int answer=digitcount(n);
        System.out.println("The count of digit in the number is :"+answer);
    }
    public static int digitcount(int n)
    {
        if(n==0)
            return 0;
        else
            return digitcount(n/10)+1;      //adding 1 on each call  and reducing n by 1 digit
    }
}
