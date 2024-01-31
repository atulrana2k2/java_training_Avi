import java.util.ArrayList;
import java.util.Scanner;

public class arraylistsum {
    public static void main(String[] args)
    {
    Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
       int s= sc.nextInt();
       int sum=0;
        ArrayList<Integer> ARR=new ArrayList<Integer>();
        for(int i=0;i<s;i++)
        {
            ARR.add(sc.nextInt());
        }
        for(int i=0;i<s;i++)
            sum+= ARR.get(i);
        System.out.println("Sum is "+sum);
}}
