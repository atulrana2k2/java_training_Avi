package org.example;

import java.util.Scanner;

public class WildcardString {

        public static int isMatch(final String A, final String B) {
            int m = A.length();
            int n = B.length();

            boolean[][] dp = new boolean[m + 1][n + 1];

            dp[0][0] = true;

            for (int j = 1; j <= n; j++) {
                if (B.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 1];
                }
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (B.charAt(j - 1) == '?' || A.charAt(i - 1) == B.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (B.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }

            // Return the result
            return dp[m][n] ? 1 : 0;
        }


public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter first String : ");
    String string1=sc.nextLine();
    System.out.println("Enter the second String : ");
    String string2= sc.nextLine();
   int ans= isMatch(string1,string2);
    System.out.println(ans);

}

}
