import java.util.Scanner;

public class hw5 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number :");
            int n = sc.nextByte();
            for(int i = 1; i <= n; ++i){ // for each row
                int sum = 0;    //to keep track of sum of each row
                for(int j = 1; j <= i; j++){
                    sum +=j; // print the number and add it to sum
                    System.out.print(j);
                    if(j < i)
                        System.out.print("+");
                }
                System.out.print("="+sum);
                System.out.println();
            }
        }
    }

