package ParentQuestions;

//PARENT OF
// SUBSET SUM PROBLEM
// EQUAL SUM PARTITION

import java.util.Scanner;

class RecursionSol {
    public int recursion(int[] weight, int[] value, int itemNo, int capacity) {
        // Base condition
        if (itemNo >= weight.length)
            return 0;

        int added = 0;
        int notAdded = 0;
        if (weight[itemNo] > capacity) {
            // recursion - can't add the item
            notAdded = recursion(weight, value, itemNo + 1, capacity);
        } else if (weight[itemNo] <= capacity) {
            // recursion1 - add the item
            added = value[itemNo] + recursion(weight, value, itemNo + 1, capacity - weight[itemNo]);
            // recursion2 - don't add the item
            notAdded = recursion(weight, value, itemNo + 1, capacity);
        }

        return Math.max(added, notAdded);
    }

    public Object solve(int[] weight, int[] value, int capacity) {
        int answer = recursion(weight, value, 0, capacity);
        return answer;
    }
}

class Memoization {
    public int recursion(int[] weight, int[] value, int itemNo, int capacity, int[][] dp) {
        // Base condition
        if (itemNo >= weight.length)
            return 0;

        if (dp[capacity][itemNo] != -1)
            return dp[capacity][itemNo];

        int added = 0;
        int notAdded = 0;
        if (weight[itemNo] > capacity) {
            // recursion - can't add the item
            notAdded = recursion(weight, value, itemNo + 1, capacity, dp);
        } else if (weight[itemNo] <= capacity) {
            // recursion1 - add the item
            added = value[itemNo] + recursion(weight, value, itemNo + 1, capacity - weight[itemNo], dp);
            // recursion2 - don't add the item
            notAdded = recursion(weight, value, itemNo + 1, capacity, dp);
        }

        return dp[capacity][itemNo] = Math.max(added, notAdded);
    }

    public Object solve(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[capacity + 1][weight.length];
        for (int i = 0; i < weight.length; ++i) {
            // when capacity = 0, items that can be put = 0
            dp[0][i] = 0;
        }
        for (int i = 1; i <= capacity; ++i) {
            for (int j = 0; j < weight.length; ++j) {
                dp[i][j] = -1;
            }
        }

        int answer = recursion(weight, value, 0, capacity, dp);
        return answer;
    }
}

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

public class ZeroOneKnapsack {
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
        RecursionSol solution = new RecursionSol();
        Object answer = solution.solve(weight, value, capacity);
        System.out.println(answer.toString());

        //
    }
}
