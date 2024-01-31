import java.util.ArrayList;
import java.util.Scanner;

public class reversearray {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int s= sc.nextInt();
        System.out.println("Enter the elements of the array :");
        int[] array=new int[s];
        for(int i=0;i<s;i++)
        {
            array[i]=sc.nextInt();
        }
        System.out.println("Enter the location of reverse :");
        int l=sc.nextInt();
//        ArrayList<Integer> ARR=new ArrayList<Integer>();
        int m=l+1;
        int k= array.length-1;
        for(int j=1;j<=(array.length-l)/2;j++)
        {
          int temp=array[m];
          array[m]=array[k];
          array[k]=temp;
           l++;
           k--;
        }
        System.out.println("New array");
        for(int i=0;i<s;i++)
        {

            System.out.print( " " +array[i]);
        }



    }
}
