import java.io.*;
import java.util.*;

class Solution {

    public Object solve(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; ++i) {
            dp[i] = 0;
        }

        for (int i = 1; i < target + 1; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                int currCoin = coins[j];
                int tempIndex = i - currCoin;
                if (tempIndex >= 0) {
                    dp[i] += dp[tempIndex];
                }
            }
        }

        return dp[target];
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            int temp = scan.nextInt();
            arr[i] = temp;
        }

        int target = scan.nextInt();

        Solution solution = new Solution();
        Object answer = solution.solve(arr, target);
        System.out.println(answer.toString());
    }
}