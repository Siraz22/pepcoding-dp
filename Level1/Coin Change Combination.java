import java.io.*;
import java.util.*;

import javax.swing.JLabel;

class Solution {

    public Object solve(int[] coins, int target) {
        int[][] dp = new int[coins.length + 1][target + 1];

        // initialization
        for (int i = 0; i < coins.length + 1; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < target + 1; ++i) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < coins.length + 1; ++i) {
            for (int j = 1; j < target + 1; ++j) {

                int currTarget = j;
                int currCoin = coins[i - 1];

                if (currCoin <= currTarget) {
                    // we can choose to take or not take, so two choices
                    dp[i][j] = dp[i][currTarget - currCoin] + dp[i - 1][currTarget];
                } else {
                    // we can't add this coin
                    dp[i][j] = dp[i - 1][currTarget];
                }
            }
        }

        return dp[coins.length][target];
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