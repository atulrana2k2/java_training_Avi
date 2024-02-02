import java.util.Scanner;

public class searchin2dmatrix_5 {
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
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
        System.out.println("Enter the target element");
        int T= sc.nextInt();
        String s=search(array,T);

//            Basicapproach
//                for(int i=0;i<n;i++)
//            for(int j=0;j<m;j++)
//            {
//               if( array[i][j]==T);
//                System.out.println("Yes element is found");
//               return;
//            }
//
//        }
//        System.out.println("No element is not found");
        System.out.println(s);



    }
    public  static String search(int matrix[][] ,int target)
    {
        int trows=matrix.length;
        int tcoll=matrix[0].length;
        int row=0;
        int col=tcoll-1;
        while(row<trows &&col>=0)
        {
            if(matrix[row][col]==target)
                return "yes";
            else if(matrix[row][col]>target)
                col--;
            else
                row++;

            }
        return "NO";
        }
    }

