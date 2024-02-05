import java.util.Scanner;

public class lastindexofelement_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the integer x:");
        int x = sc.nextInt();

        int lastIndex = findLastIndex(arr, x, 0);

        System.out.println("Last index of " + x + " is: " + lastIndex);
    }

    public static int findLastIndex(int[] arr, int x, int currentIndex) {
        if (currentIndex == arr.length - 1) {
            // Base case: If we reach the end of the array
            if (arr[currentIndex] == x) {
                return currentIndex;
            } else {
                return -1;
            }
        }

        int nextIndex = findLastIndex(arr, x, currentIndex + 1);

        // Check the current index and the next index
        if (arr[currentIndex] == x) {
            return currentIndex;
        } else {
            return nextIndex;
        }
    }
}
