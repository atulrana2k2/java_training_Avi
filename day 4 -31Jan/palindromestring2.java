import java.util.Scanner;

public class palindromestring2 {
    public static void  main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s;
        System.out.println("Enter the word :");
        s=sc.next();
        int i=0;int j=s.length()-1;
        int flag=0;
        s=s.toLowerCase();
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else {
                flag = 1;
                break;
            }

        }
        if(flag==0)
            System.out.println("Enterd string is Palindrome");
        else
            System.out.println("Enterd string is not Palindrome");

    }
}
