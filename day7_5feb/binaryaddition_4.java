import java.util.Scanner;

public class binaryaddition_4 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String 1:");
        String s1= sc.next();
        System.out.println("Enter String 2");
        String s2= sc.next();
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry=0;
        StringBuilder ans=new StringBuilder();
        while(i>=0 ||j>=0 ||carry>0)
        {
            int sum=0;
            if(i>=0)
            {
                sum=sum+s1.charAt(i--)-'0';
            }
            if(j>=0)
            {
                sum=sum+s1.charAt(j--)-'0';
            }
            sum+=carry;
            ans.append(sum%2);
            carry=sum/2;

        }
        ans.reverse();
        System.out.println(ans);
    }
}
