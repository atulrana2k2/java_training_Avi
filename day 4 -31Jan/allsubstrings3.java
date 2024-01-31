import java.util.Scanner;

public class allsubstrings3 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s;
        System.out.println("Enter the word :");
        s=sc.next();
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<s.length()+1;j++)
            {
                System.out.println(s.substring(i,j));
            }
        }
    }
}
