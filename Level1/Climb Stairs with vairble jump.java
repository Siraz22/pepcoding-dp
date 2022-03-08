import java.io.*;
import java.util.*;

class Solution {

    public Object solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] dp = new int[n + 1];

        // smaller subproblem from right to left
        dp[n] = 1;

        for (int i = n - 1; i >= 0; --i) {
            int availableSteps = A.get(i);
            for (int j = 1; j <= availableSteps; ++j) {
                int tempIndex = i + j;
                if (tempIndex >= dp.length)
                    break;
                else
                    dp[i] += dp[tempIndex];
            }
        }
        return dp[0];
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
        Object answer = sol.solve(A);
        System.out.println(answer.toString());
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();

        for (int i = 0; i < n; ++i) {
            int temp = scan.nextInt();
            A.add(temp);
        }

        Solution solution = new Solution();

        Object answer = solution.solve(A);
        System.out.println(answer.toString());
    }
}