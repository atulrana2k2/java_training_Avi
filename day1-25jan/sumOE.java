import java.util.Scanner;

public class sumOE {
    public static void main(String[] args)
    {
        int sumE=0,sumO=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter The Number");
        int n=sc.nextInt();
        while(n>0)
        {
            int r=n%10;
            if(r%2==0)
                sumE=sumE+r;
            else
                sumO=sumO+r;
            n=n/10;
        }
        System.out.println("Sum of even no :"+ sumE);
        System.out.println("sum of odd no :"+ sumO);
    }
}
