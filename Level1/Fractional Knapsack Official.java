import java.io.*;
import java.util.*;

class Solution {

    public Object solve(int[] value, int[] weight, int capacity) {
        ArrayList<ArrayList<Float>> arr = new ArrayList<ArrayList<Float>>();
        for (int i = 0; i < weight.length; ++i) {
            ArrayList<Float> temp = new ArrayList<Float>();
            temp.add((float) weight[i]);
            temp.add((float) value[i] / weight[i]); // value per unit weight
            arr.add(temp);
        }
        Collections.sort(arr, new Comparator<ArrayList<Float>>() {
            @Override
            public int compare(ArrayList<Float> first, ArrayList<Float> second) {
                return second.get(1).compareTo(first.get(1));
            }
        });
        // System.out.println(arr);

        float answer = 0;
        for (int i = 0; i < arr.size(); ++i) {
            float currWeight = arr.get(i).get(0);
            float currValuePerUnit = arr.get(i).get(1);

            if (capacity <= 0) {
                break;
            } else {
                if (currWeight <= capacity) {
                    capacity -= currWeight;
                    answer += currValuePerUnit * currWeight;
                } else {
                    // take up partials
                    answer += currValuePerUnit * capacity;
                    capacity = 0;
                }
            }
        }

        return answer;
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