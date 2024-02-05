import java.util.Scanner;

public class removeD_5 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String:");
        String s= sc.next();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
                continue;
            else
                ans.append(s.charAt(i));

        }
        ans.append(s.charAt((s.length()-1)));
        System.out.println(ans);
    }
}
