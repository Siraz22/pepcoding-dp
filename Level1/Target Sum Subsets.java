import java.io.*;
import java.util.*;

class Solution {

    public Object solve(int[] arr, int target) {

        int[][] dp = new int[arr.length + 1][target + 1];
        for (int i = 0; i < arr.length + 1; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < target + 1; ++i) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < arr.length + 1; ++i) {
            for (int j = 1; j < target + 1; ++j) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[arr.length][target] == 1 ? true : false;
        // return dp[arr.length][target];
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