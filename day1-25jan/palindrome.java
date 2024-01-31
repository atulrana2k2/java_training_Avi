import java.util.Scanner;
public class palindrome {
    public static void main(String[] args) {
        int n, rem, rev = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        n = sc.nextInt();
        int temp = n;
        while (temp > 0) {
            rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp / 10;
        }
        if (n == rev)
            System.out.println("the no is palindrome");
        else
            System.out.println("the no " + n + " is not palindrome");
    }
}

