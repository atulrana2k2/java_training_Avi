import java.util.Scanner;
import java.util.Arrays;

public class sort012_4 {
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
     int low=0,mid=0,high= array.length-1;
        while(mid<=high)
        {
            if(array[mid]==0){
                int temp=array[mid];
                array[mid]=array[low];
                array[low]=temp;
                low++;
                mid++;
            }
            else if(array[mid]==1){
                mid++;
            }
            else {
                int temp = array[mid];
                array[mid] = array[high];
                array[high] = temp;
                high--;
            }
            }
        for(int i=0;i<s;i++)
            System.out.print(array[i]+" ");

    }
    }
