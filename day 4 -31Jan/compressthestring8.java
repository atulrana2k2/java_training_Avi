import java.util.Scanner;

public class compressthestring8 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s;
        System.out.println("Enter the string :");
        s=sc.next();
        int[] check=new int[126];
        for(int i=0;i<126;i++)
            check[i]=0;
        for(int i=0;i<s.length();i++)
        {
            check[s.charAt(i)]+=1;
        }
        for(int i=0;i<126;i++)
        {
            if(check[i]>1)
            {
                System.out.print(((char)i));
                System.out.print(check[i]);
                check[i]=0;
        }
            else if(check[i]==1)
            {
                System.out.print((char)i);
            }

    }
}}
