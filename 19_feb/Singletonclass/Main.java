package Singletonclass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter the Name of Prime Minister : ");
            String s = sc.next();
            sc.nextLine();
            SingleTon obj = SingleTon.getInstance(s);                   //creating 1 instance
            System.out.println("Enter the Name of Prime Minister");
            String s2 = sc.next();
            sc.nextLine();
            SingleTon obj2 = SingleTon.getInstance(s2);                 //creating 2 instance(Not Created)

        } catch (InputMismatchException e) {
            System.out.println("Invalid input type");
        }
    }
}
