import java.util.Scanner;

public class string2number_3 {
    static int n=10;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String s=sc.next();
        int l=s.length()-1;
       int ans= convert(s,l);
        System.out.println(ans);
    }
    public static int convert(String s,int l)
    {
        if(l<0)
            return 0;
        else
            return convert(s,l-1)*n+(s.charAt(l)-'0');          //multiplying by 10 and adding the last char
                                                                    //converting char to int by -'0'
    }
}
