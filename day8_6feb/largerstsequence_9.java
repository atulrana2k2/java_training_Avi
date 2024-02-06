import java.util.Scanner;

public class largerstsequence_9{

    public static int longestincreasingsequence(int[] arr) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int length = longestsubsequencerecursive(arr, i);
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static int longestsubsequencerecursive(int[] arr, int currentIndex) {
        if (currentIndex == 0) {
            return 1;
        }

        int maxLength = 1;
        for (int i = 0; i < currentIndex; i++) {
            if (arr[currentIndex] > arr[i]) {
                int subsequenceLength = longestsubsequencerecursive(arr, i);
                maxLength = Math.max(maxLength, subsequenceLength + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Length of the longest increasing subsequence: " + longestincreasingsequence(arr));
    }}
