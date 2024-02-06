import java.util.Scanner;

public class palindrom_2 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String :");
        String s=sc.next();
        int i=0;
        int l=s.length()-1;
       boolean a= palindrome(s,i,l);
        System.out.println(a);
    }
    public static boolean palindrome(String s,int i,int l)
    {
        if(s==null)
            return false;                   //check for null string(not palindrome)
        else if(s.length()==2)
            return true;                    //check for length 2 (always palindrome)
        else if(s.charAt(i)!=s.charAt(l))
            return false;                   //check for palindrome string
        if(i==l)
            return true;                //if you reach at middle recursively string is palindrome
        return palindrome(s,i++,l--);           //recursive all by adusting the index from frist and last

    }
}
