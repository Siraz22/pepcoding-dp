import java.io.*;
import java.util.*;

class Solution {

    public Object solve(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = matrix[0][0];

        for (int i = 1; i < col; ++i) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for (int i = 1; i < row; ++i) {
            dp[i][0] += dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < col; ++j) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[row - 1][col - 1];
    }
}

class Pre {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>();
        int[] temp = { 3, 2, 4, 2, 0, 2, 3, 1, 2, 2 };
        for (int i = 0; i < temp.length; ++i) {
            A.add(temp[i]);
        }

        Solution sol = new Solution();
        Object answer = sol.solve(null);
        System.out.println(answer.toString());
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                int temp = scan.nextInt();
                matrix[i][j] = temp;
            }
        }

        Solution solution = new Solution();

        Object answer = solution.solve(matrix);
        System.out.println(answer.toString());
    }
}