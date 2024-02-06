import java.util.Scanner;

public class multiplicationusingrecursion_7 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number 1:");
        int n1= sc.nextInt();
        System.out.println("Enter the Number 2:");
        int n2= sc.nextInt();
        int result=multiply(n1,n2);
        System.out.println("The multiplication is :"+result);
    }
    public static int multiply(int n1,int n2)
    {
        if(n1==0 || n2==0)
            return 0;
        else
            return n2+multiply(n1-1,n2);            //returning (n2 + n2) upto n1 time i.e multiplication of n1*n2

    }
}
