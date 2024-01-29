import java.util.Scanner;

public class pattern3 {
    public static void main(String[] args){
        int i,j,n,k=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the input");
        n=sc.nextInt();
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if((i+j)%2==0 && (i+j)<n )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

}
