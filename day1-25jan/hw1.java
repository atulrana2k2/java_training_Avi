import java.util.Scanner;
import java.util.ArrayList;
public class hw1 {
    public static void  main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the Decimal number :");
        int n=sc.nextInt();
//        int[] array=new int[1000];
        ArrayList<Integer>array=new ArrayList<Integer>();
        int i=0;
        while(n>0)
        {
            array.add(n%2);
            n=n/2;
            i++;
        }
//        System.out.println(array.size());
        for(int j=i-1;j>=0;j--)
            System.out.print(array.get(j));

}}
