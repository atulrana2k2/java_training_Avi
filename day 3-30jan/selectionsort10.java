import java.util.HashSet;
import java.util.Scanner;

public class selectionsort10 {
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array:");
    int s=sc.nextInt();
    int[] array=new int[s];
        System.out.println("Enter the elements of the array :");
        for(int i=0;i<s;i++)
    {
        array[i]= sc.nextInt();
    }

        for(int i=0;i<s-1;i++)
        {
            int min=i;
            for(int j=i+1;j<s;j++) {
                if (array[j] < array[min]) {
                    min = j;

                }
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
        System.out.println("The sorted array will be :");
        for(int i=0;i<s;i++)
            System.out.print(array[i]+(" "));
}}
