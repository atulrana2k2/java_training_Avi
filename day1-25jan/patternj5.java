import java.util.Scanner;

public class patternj5 {
    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            for(int j=70-i;j<=69;j++)
                System.out.print((char)j);

        System.out.println();
    }
}}
