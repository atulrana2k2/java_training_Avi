import java.util.Scanner;

public class numberraisedtorevers_13 {

    private static final long MOD = 1000000007;

    public static long powerOfReverse(long N, long R) {
        long reversedNumber = reverseNumber(R);
        long result = power(N, reversedNumber);
        return result % MOD;
    }

    public static long power(long base, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        long temp = power(base, exponent / 2);
        long result = (temp * temp) % MOD;
        if (exponent % 2 == 0) {
            return result;
        } else {
            return (result * base) % MOD;
        }
    }

    public static long reverseNumber(long number) {
        return reverseHelper(number, 0);
    }

    private static long reverseHelper(long number, long reversed) {
        if (number == 0) {
            return reversed;
        }
        return reverseHelper(number / 10, reversed * 10 + number % 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number N: ");
        long N = scanner.nextLong();

        System.out.print("Enter the reverse R: ");
        long R = scanner.nextLong();

        long result = powerOfReverse(N, R);

        System.out.println("Output: " + (int)result);

        scanner.close();
    }
}
