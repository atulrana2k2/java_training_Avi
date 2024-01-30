import java.util.Scanner;

public class matrixsum15 {
    public static void  main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of square matrix :");
        int n= sc.nextInt();
        int[][] arr=new int[n][n];
        System.out.println("Enter the elements of the matrix :");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
               arr[i][j]=sc.nextInt();
            }
        }
        int sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j){
                    sum+=arr[i][j];
                arr[i][j]=0;
            }
        }}

        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (i + j == n - 1) {
                    sum += arr[i][j];
                    arr[i][j] = 0;
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for( int j=0;j<n;j++)
            {
                if( i==0 || j==0 || i==(n-1) || j==(n-1))
                    sum+=arr[i][j];
            }

        }
//        System.out.println(sum1);
//        System.out.println(sum2);
//        System.out.println(sum3);
        System.out.println("sum is="+ sum);
    }
}
