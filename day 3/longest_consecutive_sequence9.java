//to find the the length of longest sequence N,N+1,N+2=3
import java.util.HashSet;
import java.util.Scanner;

public class longest_consecutive_sequence9 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int s=sc.nextInt();
        int[] array=new int[s];
        System.out.println("Enter the elements of the array :");
        HashSet<Integer> H=new HashSet<>();
        for(int i=0;i<s;i++)
        {
            array[i]= sc.nextInt();
            H.add(array[i]);
        }
       int length=0;
        for(int i=0;i<s;i++)
        {
            if(H.contains(array[i-1])==false)
            {
                int currentlength=1;
                int currentelement=array[i];
                while(H.contains(currentelement+1))
                {
                    currentlength++;
                    currentelement++;
                }
                length=Math.max(length,currentlength);
            }
        }
        System.out.println("Length of the longest sequence is = "+length);


    }

}
