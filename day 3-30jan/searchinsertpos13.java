import java.util.Scanner;

public class searchinsertpos13 {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter sorted  elements of array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number");
        int number= sc.nextInt();
        int i=0;
        for(;i<n;i++)
        {
            if(arr[i]>number)
                break;
        }
        System.out.println("The target location is :"+ i);
    }

}
