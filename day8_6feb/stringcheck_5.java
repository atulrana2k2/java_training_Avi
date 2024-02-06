import java.util.Scanner;
public class stringcheck_5 {
    static int i=0;
    static String ans="";
    static boolean flag=true;
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);  //scanner object
        String s;
        System.out.println("Enter the string");
        s=sc.next();
        System.out.println(check(s));
    }
    static boolean check(String s)
    {
        if(i==0&&s.charAt(i)!='a')
            return false;
        if(i==s.length()-1)
            return flag;
        if(s.contains("bbb")||s.contains("abbb")) //no bb will be followed by a b
        {
            flag=false;
            return flag;
        }
        else if(s.contains("abb")||s.contains("bba")||s.contains("aa")||s.contains("bb")) //verify all the possible string
        {
            check(s.substring(i+1,s.length())); //we shorten the string
        }
        else
        {
            flag=false;
            return flag;
        }
        return flag;

    }
}
