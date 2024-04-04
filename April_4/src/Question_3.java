
public class Question_3 {
    public int[] sortColors(int[] A) {
        int low = 0, mid = 0, high = A.length - 1;
        while (mid <= high) {
            if (A[mid] == 0) {
                swap(A, low, mid);
                low++;
                mid++;
            } else if (A[mid] == 1) {
                mid++;
            } else {
                swap(A, mid, high);
                high--;
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

