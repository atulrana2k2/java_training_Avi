import java.util.Scanner;

public class sumof2array {
    public static void  main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int s=sc.nextInt();
        int[] array1=new int[s];
        System.out.println("Enter the elements of the array :");
        for(int i=0;i<s;i++)
            array1[i]= sc.nextInt();
        System.out.println("Enter the size of the second array:");
        int s2=sc.nextInt();
        int[] array2=new int[s2];
        System.out.println("Enter the elements of the second array :");
        for(int i=0;i<s2;i++)
            array2[i]=sc.nextInt();
        int product=0,product2=0;
        for(int i=0;i<s;i++)
        {
            product=product*10+array1[i];
        }
        for(int i=0;i<s2;i++)
        {
            product2=product2*10+array2[i];
        }
        System.out.println("Sum of two arrays are :"+(product+product2));

    }
}
