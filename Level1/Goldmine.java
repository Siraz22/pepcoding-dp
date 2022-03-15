import java.io.*;
import java.util.*;

class Solution {

    public int recursion(int[][] matrix, int row, int col, int curr_row, int curr_col, int[][] dp) {
        // base condition - reached the end (rightmost wall)
        if (curr_col == col - 1)
            return dp[curr_row][curr_col] = matrix[curr_row][curr_col];

        if (dp[curr_row][curr_col] != -1)
            return dp[curr_row][curr_col];

        int front = recursion(matrix, row, col, curr_row, curr_col + 1, dp);

        int up = -1;
        int down = -1;
        if (curr_row != 0) {
            up = recursion(matrix, row, col, curr_row - 1, curr_col + 1, dp);

        }
        if (curr_row != row - 1) {
            down = recursion(matrix, row, col, curr_row + 1, curr_col + 1, dp);

        }
        return dp[curr_row][curr_col] = (matrix[curr_row][curr_col] + Math.max(front, Math.max(up, down)));
    }

    public Object solve(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                dp[i][j] = -1;
            }
        }

        int answer = -1;

        for (int i = 0; i < row; ++i) {
            int goldMined = recursion(matrix, row, col, i, 0, dp);
            answer = Math.max(goldMined, answer);
        }

        return answer;
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