import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;

public class setmatrix0_1 {
    public static void  main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of rows :");
        int n= sc.nextInt();
        System.out.println("Enter the number of columns :");
        int m= sc.nextInt();
        int[][] array=new int[n][m];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                array[i][j]=sc.nextInt();
            }
        }
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(array[i][j]==0)
                {
                   map.put(i,j);
                }
            }
        }

       map.forEach((k,v)->{
           int e=k;
           int r=v;
           for(int i=0;i<n;i++)
               array[i][v]=0;
           for(int i=0;i<m;i++)
               array[k][i]=0;

       });
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(array[i][j]+" ");
            }
        }



    }
}
