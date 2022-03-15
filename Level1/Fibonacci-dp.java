import java.io.*;
import java.util.*;

class Solution {
    public Object solve(int n) {
        int[] dp = new int[n];
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Solution solution = new Solution();

        Object answer = solution.solve(n);
        System.out.println(answer.toString());
    }
}