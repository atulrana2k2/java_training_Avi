package org.example;

import java.util.Scanner;

public class ArrayProblem_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the Arrays :");
        int size= sc.nextInt();
        int[] gas=new int[size];
        int[] cost=new int[size];
        System.out.println("Enter the 1 Array (gas) : ");
        for(int i=0;i<size;i++){
            gas[i]=sc.nextInt();
        }
        System.out.println("Enter the 2 Array (cost) : ");
        for(int i=0;i<size;i++){
            cost[i]=sc.nextInt();
        }
        for(int i=0;i<size;i++)
        {
            int GasPresent=0;
            boolean complete=true;
            for (int j = i; j < size+i; j++)
            {
                int index=j%size;
                GasPresent+=gas[index];
                GasPresent-=cost[index];
                if(GasPresent<0)
                {
                         complete=false;
                         break;

                }
            }
            if(complete)
            {
                System.out.println("Starting Index at of gas station (minimum) : "+i);
                return;

            }
        }
        System.out.println("No valid Station found");

    }

}