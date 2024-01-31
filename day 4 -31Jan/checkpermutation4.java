import java.util.Scanner;

public class checkpermutation4 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s,s2;
        System.out.println("Enter the  1 word :");
        s=sc.next();
        System.out.println("Enter the 2 word :");
        s2=sc.next();

        int[] check=new int[126];
        for(int i=0;i<126;i++)
            check[i]=0;
        for(int i=0;i<s.length();i++)
        {
            check[s.charAt(i)]+=1;
            check[s2.charAt(i)]-=1;
        }
        int flag=1;
        for(int i=0;i<126;)
        {
            if(check[i]==0)
                i++;
            else{
                flag=0;
                break;
            }
        }
        if(flag==1)
            System.out.println("TRUE");
        else
            System.out.println("False");
    }
}
