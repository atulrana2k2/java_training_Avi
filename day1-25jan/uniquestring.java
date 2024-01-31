import java.util.Scanner;

public class uniquestring {
    public static void main(String[] args)
    {
        String sentence;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        sentence=sc.next();
        char[] arr=new char[200];
        for(int i =0;i<200;i++)
            arr[i]=0;

        for(int i=0;i<sentence.length();i++)
            arr[sentence.charAt(i)]+=1;
        for(int i=0;i<200;i++)
        {
            if(arr[i]==1)
            System.out.print((char)(i));
        }

    }
}
