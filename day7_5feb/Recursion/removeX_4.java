import java.util.Scanner;

public class removeX_4 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String s= sc.next();
       String ans= removex(s,s.length()-1);
        System.out.println(ans);

    }
    public static String removex(String s ,int l) {
        StringBuilder A = new StringBuilder();
       if(l<0) {
                return A.toString();
       }
       else{
           if(s.charAt(l)!='x'&& s.charAt(l)!='X')
           {
               A.append(s.charAt(l));
           }
            return removex(s,l-1).concat(A.toString());
       }

       }}

