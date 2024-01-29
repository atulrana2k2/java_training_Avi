import java.util.Scanner;

public class temp {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the start value");
        int s=sc.nextInt();
        System.out.println("enter the end value");
        int e=sc.nextInt();
        System.out.println("enter the gap");
        int w= sc.nextInt();
        for(int i=s;i<=e;i+=w)
        {
            float c=(i-32)*5/9;
            System.out.println(i+"F="+c);
        }

    }
}
