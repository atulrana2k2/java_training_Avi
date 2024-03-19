package HashSet;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class absoluteDifferenceK {

    public static int longestSubarrayLength(int[] nums, int k) {
        int maxLength = 0;
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxQueue.isEmpty() && nums[right] > maxQueue.peekLast())
                maxQueue.removeLast();
            maxQueue.addLast(nums[right]);

            while (!minQueue.isEmpty() && nums[right] < minQueue.peekLast())
                minQueue.removeLast();
            minQueue.addLast(nums[right]);

            while (maxQueue.peekFirst() - minQueue.peekFirst() > k) {
                if (maxQueue.peekFirst() == nums[left])
                    maxQueue.removeFirst();
                if (minQueue.peekFirst() == nums[left])
                    minQueue.removeFirst();
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the value of limit: ");
        int limit = scanner.nextInt();

        System.out.println("Length of the longest subarray: " + longestSubarrayLength(nums, limit));
    }
}
