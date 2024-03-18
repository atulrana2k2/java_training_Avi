package linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class add2LinkedList {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> List1=new LinkedList<>();
        System.out.println("Enter the  no of elements in Linked List 1 (non zero) : ");
        int linkList1Size=scanner.nextInt();
        for(int values=0;values<linkList1Size;values++)
        {
            System.out.println("Enter the "+(values+1)+"element : ");
            int element=scanner.nextInt();
            List1.add(element);
        }


        List<Integer> List2=new LinkedList<>();
        System.out.println("Enter the  no of elements in Linked List 2 (non zero) : ");
        int linkList2Size=scanner.nextInt();
        for(int values=0;values<linkList2Size;values++)
        {
            System.out.println("Enter the "+(values+1)+"element : ");
            int element=scanner.nextInt();
            List2.add(element);
        }


        int ResultList1=0;
        for(int element:List1)
        {
            ResultList1=ResultList1*10+element;
        }



        int ResultList2=0;
        for(int element:List2)
        {
            ResultList2=ResultList2*10+element;
        }


        System.out.println("Adding two number produces : "+(ResultList1+ResultList2));



    }
}
