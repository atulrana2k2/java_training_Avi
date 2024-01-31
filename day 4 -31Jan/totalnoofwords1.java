import java.util.Scanner;

public class totalnoofwords1 {
    public static void  main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s;
        System.out.println("Enter the sentence :");
        s=sc.nextLine();
        s=s+" ";
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
                count++;
        }
        System.out.println("Number of words in the sentence is : "+count );
    }
}
