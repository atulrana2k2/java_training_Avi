import java.util.Scanner;

public class hwpattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input");
        int n = sc.nextInt();
        int i;
        for (i = 1; i <= n; i++) {


            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            int Num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(Num);
                Num++;
            }

            Num -= 2;
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(Num);
                Num--;
            }

            System.out.println();
        }
    }
}