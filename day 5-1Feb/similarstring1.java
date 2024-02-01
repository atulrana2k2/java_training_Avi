import java.util.Scanner;

public class similarstring1 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s,s2;
        System.out.println("Enter the  1 string :");
        s=sc.next();
        System.out.println("Enter the 2 string :");
        s2=sc.next();
        int flag=0;
        if(s.length()==s2.length())
        {
            for(int i=0;i<s.length();i++)
            {
               if( s.charAt(i)!=s2.charAt(i))
               {
                   System.out.println("Strings are not similar");
                   flag=1;
                   break;
            }}
               if(flag==0)
                   System.out.println("Strings are similar");

    }
}}
