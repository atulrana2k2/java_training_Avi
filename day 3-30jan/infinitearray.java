import java.util.ArrayList;
import java.util.Scanner;

public class infinitearray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Array :");
        int N = sc.nextInt();
        int[] array = new int[N];
        System.out.println("Enter the elements of the Array :");
        for (int i = 0; i < N; i++)
            array[i] = sc.nextInt();
        ArrayList<Integer> array2 = new ArrayList<>();
        int sum = 0;
        System.out.println("Enter the querry size:");
        int k = sc.nextInt();
int j=0;
        for (int i = 0; i < k; i++) {
            array2.add(array[j]);
            j++;
            if (j == N)
                j = 0;
        }
//        for(int i=0;i<k;i++) to check the infinite array wanted
//        System.out.println(array2.get(i));
        System.out.println("Sum is:");
        for (int i = 0; i < k; i++) {
            sum += array2.get(i);
        }
        System.out.println(sum);
    }
}