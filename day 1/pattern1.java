import java.util.Scanner;

public class pattern1 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows :");
        int n=sc.nextInt();
        int i,j,k=1;
        for (i=0;i<n;i++)
        {
            k=1;
            for(j=0;j<n;j++)
            {
                if(i>=j)
                    System.out.print(k++ + " ");

            }
            System.out.println();
        }
    }
}
