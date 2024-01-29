import java.util.Scanner;

public class power {
    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value");
        int n= sc.nextInt();
        int ans=1;
        System.out.println("Ente the power");
        int p=sc.nextInt();
        if(p==0)
            System.out.println("ans="+ 1);
        else
            while(p>0)
            {
                ans=ans*n;
                p--;
            }
        System.out.println("the answer is "+ ans);
    }
}
