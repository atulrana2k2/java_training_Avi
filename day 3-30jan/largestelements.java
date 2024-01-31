import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

//k largest element in a array
public class largestelements {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int s=sc.nextInt();
        int[] array=new int[s];
        System.out.println("Enter the elements of the array :");
        for(int i=0;i<s;i++)
        {
            array[i]= sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println("Enter number to find number of largest elements :");
        int k=sc.nextInt();
//
        for (int i = s - k; i < s; i++) {
            if(array[i]==array[i+1])
            System.out.println(array[i]);
        }

    }
}
