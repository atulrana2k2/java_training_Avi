

public class Question_1{
    public int isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();
        int p = C.length();

        // If the lengths of A and B don't add up to the length of C, return false
        if (m + n != p) {
            return 0;
        }

        // Create a boolean array to store the result of subproblems
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Initialize the first cell to true, as empty strings can be interleaved to form an empty string
        dp[0][0] = true;

        // Check if A can be interleaved to form C
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && A.charAt(i - 1) == C.charAt(i - 1);
        }

        // Check if B can be interleaved to form C
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && B.charAt(j - 1) == C.charAt(j - 1);
        }

        // Check if both A and B can be interleaved to form C
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current character of C matches with the character of A and the result of the previous subproblem for A is true
                // or if the current character of C matches with the character of B and the result of the previous subproblem for B is true
                dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
            }
        }

        // Return 1 if the last cell is true, indicating that C can be formed by interleaving A and B
        return dp[m][n] ? 1 : 0;
    }
}


