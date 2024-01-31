import java.util.*;

public class findduplicates3 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int s = sc.nextInt();
        Set<Integer> set=new HashSet<>();
        int[] array = new int[s];
        System.out.println("Enter the elements of the array :");
        for (int i = 0; i < s; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        for(int i=0;i<s-1;i++)
        {
            if(array[i]==array[i+1])
                set.add(array[i]);
        }
        System.out.println(set);
    }
}
