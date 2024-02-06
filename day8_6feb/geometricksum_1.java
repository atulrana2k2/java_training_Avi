import java.util.Scanner;

public class geometricksum_1 {
    public static void  main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of  K :");
        double k= sc.nextInt();
       double answer = geometricsum(k);
        System.out.println("The geometric sum is "+answer);
    }
    public static double geometricsum(double k)
    {
        if(k==0)                //base case approaching by(k-1) on each recursive call
            return 1;
        else
            return geometricsum(k-1)+(1/Math.pow(2,k));   //adding value in each recursive call
    }
}
