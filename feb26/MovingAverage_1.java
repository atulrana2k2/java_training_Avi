package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class MovingAverage_1 {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        try {
            try {
                System.out.print("Enter the size of the input vector: ");
                int size = scanner.nextInt();
                if (size < 1)
                    throw new InputMismatchException();


                Vector<Integer> vect = new Vector<>(size);
                System.out.println("Enter the elements of the input vector:");
                for (int i = 0; i < size; i++) {
                    System.out.print("Element " + (i + 1) + ": ");
                    vect.add(scanner.nextInt());
                }


                System.out.print("Enter the size of the window : ");
                int window_size = scanner.nextInt();

                Vector<Integer> ans = calc_mov_avg(size, vect, window_size);
                int n = ans.size();


                System.out.println("\nn = " + n);
                System.out.print("result = " + ans);
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }
            scanner.close();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

        public static Vector<Integer> calc_mov_avg ( int size, Vector<Integer > vect,int window_size){
        Vector<Integer> vector = new Vector<>();

        for (int i = 0; i < size - window_size + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + window_size; j++) {
                sum += vect.get(j);
            }
            vector.add(Math.round(sum / (float) window_size));
        }

        return vector;
    }
    }
