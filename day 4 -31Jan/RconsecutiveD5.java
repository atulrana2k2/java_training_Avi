import java.util.Scanner;

public class RconsecutiveD5 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s;
        System.out.println("Enter the word :");
        s=sc.next();
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
                continue;
            else
                System.out.print(s.charAt(i));
        }
        System.out.println(s.charAt(s.length()-1));
    }
}
