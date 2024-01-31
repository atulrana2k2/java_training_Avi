import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class uniquearray {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int s= sc.nextInt();
        int[] array=new int[s];
        System.out.println("Enter the elements of the array :");
        for(int i=0;i<s-1;i++)
            array[i]= sc.nextInt();
        Arrays.sort(array);
        int size=0;
        for(int i=1;i<s;i++)
        {
           if(array[i]==array[i-1])
               continue;
           else
               size++;
            }
        System.out.println(size);
        }

    }


