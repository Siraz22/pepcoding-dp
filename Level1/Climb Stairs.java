import java.io.*;
import java.util.*;

class Solution {
    public Object solve(int n) {
        int[] dp = new int[n + 1];

        if (n == 0 || n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 4;

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < n + 1; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
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