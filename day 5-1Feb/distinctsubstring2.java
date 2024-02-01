import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class distinctsubstring2 {
    public static void main(String args[]) {
        Set<String> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String s;
        System.out.println("Enter the string :");
        s = sc.next();
        int[] check=new int[126];
        for(int i=0;i<126;i++)
            check[i]=0;
        for(int i=0;i<s.length();i++)
        {
            check[s.charAt(i)]+=1;
        }
        int count=0;
        for(int i=0;i<126;i++)
        {
            if(check[i]>1)
            {
                count=count+check[i]-1;
            }
        }
        System.out.println("No of charcter you want to change :"+count);
    }
}