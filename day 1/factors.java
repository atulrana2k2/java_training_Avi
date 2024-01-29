import java.util.Scanner;

public class factors {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int count=0;
        System.out.println("Enter the  number");
        int n=sc.nextInt();
        for(int i=2;i<=n/2;i++)
        {
            if((n%i)==0)
            {
                count++;
                System.out.print(" " +i);
            }
        }
        System.out.println(n);
        if(count==0)
            System.out.println(-1);


    }
}
