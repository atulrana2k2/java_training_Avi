import java.util.Scanner;

public class count {
    public static void  main(String[] args)
    {
        int count=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n= sc.nextInt();
        while(n>0)
        {
            count++;
            n/=10;
        }
        System.out.println("The no of digit are =" + count);
    }
}
