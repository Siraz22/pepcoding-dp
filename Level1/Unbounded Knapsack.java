import java.io.*;
import java.util.*;

class Solution {

    public Object solve(int[] value, int[] weight, int target) {

        int[][] dp = new int[weight.length + 1][target + 1];

        // initialization
        for (int i = 0; i < weight.length + 1; ++i) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < target + 1; ++i) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < weight.length + 1; ++i) {
            for (int j = 1; j < target + 1; ++j) {

                int currWeight = weight[i - 1];
                int currCapacity = j;

                if (currCapacity >= currWeight) {
                    // option to choose or not to choose
                    dp[i][j] = Math.max(value[i - 1] + dp[i][currCapacity - currWeight], dp[i - 1][currCapacity]);
                } else {
                    dp[i][j] = dp[i - 1][currCapacity];
                }
            }
        }
        return dp[weight.length][target];
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] value = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; ++i) {
            int temp = scan.nextInt();
            value[i] = temp;
        }

        for (int i = 0; i < n; ++i) {
            int temp = scan.nextInt();
            weight[i] = temp;
        }

        int target = scan.nextInt();

        Solution solution = new Solution();
        Object answer = solution.solve(value, weight, target);
        System.out.println(answer.toString());
    }
}