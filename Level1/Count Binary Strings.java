import java.io.*;
import java.util.*;

class Solution {

    public Object solve(int n) {
        int[][] dp = new int[2][n];

        // initialize
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 1; i < n; ++i) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
        }

        return dp[0][n - 1] + dp[1][n - 1];
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Solution solution = new Solution();
        Object answer = solution.solve(n);
        System.out.println(answer.toString());
    }
}