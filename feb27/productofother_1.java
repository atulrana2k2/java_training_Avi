package org.example;

import java.util.Scanner;

public class productofother_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size=sc.nextInt();
        int[] array=new int[size];
        int product=1;
        System.out.println("Enter the elements of the array : ");
        for(int i=0;i<size;i++)
        {
            array[i]= sc.nextInt();
            product=product*array[i];
        }
        int[] arrayans=new int[size];
        for(int i=0;i<size;i++)
        {
            arrayans[i]= product / array[i];
        }
        System.out.println("Resultant Array : ");
        for(int i=0;i<size;i++)
        {
            System.out.print(arrayans[i]+" ");
        }
    }
}
