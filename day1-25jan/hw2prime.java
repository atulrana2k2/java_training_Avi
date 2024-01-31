import java.util.Scanner;

public class hw2prime {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number :");
        int n=sc.nextInt();

        while(n>1)
        {
            int count=0;;
            for(int i=2;i<=n/2;i++)
            {
                if(n%i==0)
                {
                    count++;
                }

            }
            if(count==0)
                System.out.print(n+" ");
            n--;
        }
    }
}
