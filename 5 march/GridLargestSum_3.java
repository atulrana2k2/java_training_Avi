import java.util.Scanner;

public class GridLargestSum_3 {


    public static int maxSumNoAdjacent(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0)
            return 0;

        int rows = A.length;
        int cols = A[0].length;

        int[][] dp = new int[rows][cols];

        // Base cases
        dp[0][0] = A[0][0];

        if (cols > 1)
            dp[0][1] = Math.max(A[0][0], A[0][1]);

        // Fill the dp table
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j < 2)
                    continue;

                // Check for adjacent elements
                int adjSum = Math.max(i > 0 ? dp[i - 1][j] : 0, j > 0 ? dp[i][j - 1] : 0);
                dp[i][j] = Math.max(adjSum, j > 1 ? dp[i][j - 2] + A[i][j] : A[i][j]);
            }
        }

        // Return the maximum sum from the last row
        int maxSum = 0;
        for (int j = 0; j < cols; j++) {
            maxSum = Math.max(maxSum, dp[rows - 1][j]);
        }
        return maxSum;
    }


    public static void main(String[] args) {

        //taking Input of the grid
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of columns in the grid : ");
        int NoOfColumn= sc.nextInt();
        int[][] Grid=new int[2][NoOfColumn];
        System.out.println("Enter the Elements of the grid : ");
        for(int  rowElement=0; rowElement<2; rowElement++)
        {
            for(int columnElement=0;columnElement<NoOfColumn;columnElement++)
            {
                Grid[ rowElement][columnElement]= sc.nextInt();
            }
        }

        System.out.println(maxSumNoAdjacent(Grid));


    }
}

