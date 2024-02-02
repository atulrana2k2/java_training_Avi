import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class sumofzeroes_2 {
   static int fcount=0;
    public static void main(String args[]){
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
        int fcount=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) {
                if (array[i][j] == 0)
                    fcount += findcoverage(array,i, j);
            }

            }
        System.out.println("coverage is :"+fcount);
        }
        public static int findcoverage(int[][] array ,int i ,int j)
        {
            int count=0;
            if(i-1<0)
            {}
            else if(array[i-1][j]==1)
                count++;
            if(i+1==array.length){}
            else if(array[i+1][j]==1)
                count++;
            if(j-1<0)
            {}
            else if(array[i][j-1]==1)
                count++;
            if(j+1==array[0].length)
            {}
            else if(array[i][j+1]==1)
                count++;
            return count;


    }
}
