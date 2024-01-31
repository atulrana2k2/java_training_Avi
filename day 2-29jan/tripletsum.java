import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class tripletsum {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Set<String> result= new HashSet<>();
        System.out.println("Enter the size of the array :");
        int s= sc.nextInt();
        int[] array=new int[s];
         System.out.println("Enter the elements of the array :");
        for(int i=0;i<s;i++)
        {
            array[i]=sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println("Enter the sum :");
        int k=sc.nextInt();
        for(int i=0;i<(s-2);i++)
        {
            for(int j=i+1;j<(s-1);j++)
            {

                for(int l=s-1;l>j;l--)
                {

                    if ((array[i]+array[j]+array[l]==k))
                    {
                        String triplet = "[" + array[i] + "," + array[j] + "," + array[l] + "]";
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                            System.out.println(triplet);
                        }

                        break;

                    }

                }
            }
        }
    }
}
