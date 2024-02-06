import java.util.Scanner;

public class countofzeroes_8 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n= sc.nextInt();
        int answer=digitcount0(n);
        System.out.println("The count of digit in the number is :"+answer);
    }
    public static int digitcount0(int n)
    {
        if(n==0)
            return 0;
        else if(n%10==0)
            return 1+digitcount0(n/10);
        else
            return digitcount0(n/10);
    }
}
