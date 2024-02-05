import java.util.Locale;
import java.util.Scanner;

public class newstitle_2 {
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array String:");
        int n= sc.nextInt();
        String[] array=new String[n];
        System.out.println("Enter the  strings in the array:");
        for(int i=0;i<n;i++)
            array[i]=sc.next();
        sc.nextLine();
        StringBuilder Title=new StringBuilder();
        String l="";
        for(int i=0;i<n;i++)
        {
            int ind=0;
            for(int j=0;j<array[i].length();j++)
            {
                if(array[i].charAt(j)>='A'&& array[i].charAt(i)<='z')
                {
                    ind=j;
                    break;
                }
            }
            l=l+" "+(array[i].substring(ind,ind+1)).toUpperCase()+(array[i].substring(ind+1,array[i].length()));
        }
        l=l.trim();
        String ans="";
        for(int i=0;i<l.length();i++)
        {
            if((l.charAt(i)>='A'&&l.charAt(i)<='z')||l.charAt(i)==' '||l.charAt(i)==':')
                ans=ans+l.charAt(i);
        }
        System.out.println(ans);


    }
}
