import java.util.Scanner;

public class numerofoccurance1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int s = sc.nextInt();
        int[] array = new int[s];
        System.out.println("Enter the elements of the array :");
        for (int i = 0; i < s; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the number whose occurance you want to find :");
        int T= sc.nextInt();
        int count=0;
        for(int i=0;i<s;i++)
        {
            if(array[i]==T)
                count++;
        }
        System.out.println("The number of occurance of number "+T+ "is= "+count);
    }
}