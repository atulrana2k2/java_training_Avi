import java.util.Scanner;

public class Higesht_occuring_character7 {
    public static void main(String args[])
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
        int max=1;
        int k=0;
        for(int i=0;i<126;i++)
        {
            if(check[i]>max)
            {
                 k=i;
                max=check[i];
            }
        }
        if(max==1)
            System.out.println(s.charAt(0));
        else
        System.out.println("Largest ocuring charcter is :"+(char)k);
}}
