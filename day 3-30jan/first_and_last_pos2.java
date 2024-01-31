import java.util.Scanner;

public class first_and_last_pos2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int s = sc.nextInt();
        int[] array = new int[s];
        System.out.println("Enter the elements of the array :");
        for (int i = 0; i < s; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Enter the target element");
        int T= sc.nextInt();
        for(int i=0;i<s;i++)
        {
         if(array[i]==T)
             System.out.println("Frirst location found at "+i);
         else if(array[i]==T && array[i+1]!=T)
             System.out.println("End loaction found at "+i);
        }

    }
}
