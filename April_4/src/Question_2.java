


import java.util.Arrays;

public class Question_2{
    public int threeSumClosest(int[] A, int B) {
        int n = A.length;
        // Sort the array to use two-pointer approach
        Arrays.sort(A);
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        // Iterate through the array
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1; // Pointer for the element after A[i]
            int right = n - 1; // Pointer for the last element in the array

            // Move the pointers inward while checking the sum of three elements
            while (left < right) {
                int sum = A[i] + A[left] + A[right];
                int diff = Math.abs(sum - B);

                // Update the closest sum and minimum difference if needed
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }

                // If the sum is greater than the target, decrease the right pointer
                if (sum > B) {
                    right--;
                }
                // If the sum is less than the target, increase the left pointer
                else {
                    left++;
                }
            }
        }
        // Return the closest sum
        return closestSum;
    }
}

