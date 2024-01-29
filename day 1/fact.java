import java.util.Arrays;
import java.util.Scanner;
public class fact {
    public static void main(String[] args)
    {
        int fact=1;
        int a;
        System.out.println("enter the number");
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();

        while(a>0)
        {
            fact=fact*a;
            a--;
        }
        System.out.println(fact);
    }

}
