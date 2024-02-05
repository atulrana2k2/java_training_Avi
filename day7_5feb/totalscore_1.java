import java.util.Scanner;

public class totalscore_1 {
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the size of the arrray:");
        int n= sc.nextInt();
        if(n==0){
            System.out.println("Enter size is O");
            return;
        }
        System.out.println("Enter the elements of the array :");

        int[] array=new int[n];
        for(int i=0;i<n;i++)
            array[i]= sc.nextInt();
        int totalscore=0;
        for(int i=0;i<n;i++)
        {
            if(array[i]%2==0)
                totalscore++;
            else if (array[i]==5)
            {
               totalscore+=5;
            }
            else
                totalscore+=3;
        }
        System.out.println("Total score is :"+ totalscore);
    }
}
