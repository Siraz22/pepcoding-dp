import java.io.*;
import java.util.*;

class TopDownSolution {
    public Object solve(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[weight.length + 1][capacity + 1];

        for (int i = 0; i < weight.length + 1; ++i) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < capacity + 1; ++i) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < weight.length + 1; ++i) {
            for (int j = 1; j < capacity + 1; ++j) {

                int currWeight = weight[i - 1];
                int currCapacity = j;

                if (currWeight <= currCapacity) {
                    dp[i][j] = Math.max(
                            value[i - 1] + dp[i - 1][currCapacity - currWeight],
                            dp[i - 1][currCapacity]);
                } else {
                    dp[i][j] = dp[i - 1][currCapacity];
                }
            }
        }

        return dp[weight.length][capacity];
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        for (int i = 0; i < n; ++i) {
            int temp = scan.nextInt();
            value[i] = temp;
        }
        for (int i = 0; i < n; ++i) {
            int temp = scan.nextInt();
            weight[i] = temp;
        }

        int capacity = scan.nextInt();

        // RECURSION SOLUTION
        TopDownSolution solution = new TopDownSolution();
        Object answer = solution.solve(weight, value, capacity);
        System.out.println(answer.toString());

        //
    }
}