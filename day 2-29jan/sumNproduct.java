import java.util.Scanner;

public class sumNproduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number :");
        int n = sc.nextInt();
        System.out.println("Enter the operation : 1 for sum 2 for product");
        int q = sc.nextInt();
        int sum = 0, product = 0;
        switch (q) {
            case 1:

                while (n > 0) {
                    sum = sum + n % 10;
                    n = n / 10;
                }
                System.out.println("sum is = " +sum);
                break;
            case 2:
                while (n > 0) {
                    product = product * n / 10;
                    n /= 10;
                }
                System.out.println("Product ="+product);
            default:
                System.out.println("please enter a valid choice ");
        }
    }
}
