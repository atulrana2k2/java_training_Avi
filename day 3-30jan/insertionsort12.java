import java.util.Scanner;

public class insertionsort12 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 1; i < n; i++)
        {
        int temp=arr[i];
        int j=i-1;
        for(;j>=0 && arr[j]>temp;j--)
        {
            if(arr[j]>temp)
            {
                arr[j+1]=arr[j];
            }
            else
                continue;
        }
       arr[j+1]=temp;

        }
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");

}}
