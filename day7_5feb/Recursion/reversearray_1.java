import java.util.Scanner;

public class reversearray_1 {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n= sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int[] array=new int[n];
        for(int i=0;i<n;i++)
            array[i]= sc.nextInt();
        int i=0;
        reverse(array,i,array.length-1);
        for( i=0;i<n;i++)
            System.out.print(array[i]+" ");
    }
    public static void reverse(int array[],int i,int j)
    {
        if(i<j)
        {
            int temp=array[i];
            array[i]=array[j];
            array[j]=temp;
            reverse(array,i+1,j-1);

    }}}

