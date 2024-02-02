import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class sortmatrix_4 {
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        PriorityQueue<Integer> arraq=new PriorityQueue<>();
        List<Integer> sorted=new ArrayList<>();
        System.out.println("Enter the number of rows :");
        int n= sc.nextInt();
        System.out.println("Enter the number of columns :");
        int m= sc.nextInt();
        int[][] array=new int[n][m];
        System.out.println("Enter the elements of the array :");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                array[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arraq.add(array[i][j]);
            }
        }
        while(!arraq.isEmpty())
        {
            sorted.add(arraq.poll());
        }
        for(int i=0;i<sorted.size();i++)
        {
            System.out.println(sorted.get(i) +" ");
        }

    }
}
