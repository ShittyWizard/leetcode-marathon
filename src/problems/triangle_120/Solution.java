package problems.triangle_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// link - https://leetcode.com/problems/triangle/submissions/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
           2
           3 4
           6 5 7
           4 1 8 3
         */


        /*
           2
           3  4
           6  5  7
           14 21 18 1
         */
        int len = triangle.size();
        int[][] memo = new int[2][len];
        for (int[] ints : memo) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        memo[0][0] = triangle.get(0).get(0);

//        iterate over rows
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    memo[i % 2][j] = memo[(i-1) % 2][j] + triangle.get(i).get(j);
                } else {
                    memo[i % 2][j] = Math.min(memo[(i - 1) % 2][j - 1], memo[(i - 1) % 2][j]) + triangle.get(i).get(j);
                }
            }
        }
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < memo[(len - 1) % 2].length; i++) {
            if (memo[(len-1) % 2][i] < minPath) {
                minPath = memo[(len-1) % 2][i];
            }
        }
        return minPath;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(List.of(3, 4));
        triangle.add(List.of(6, 5, 7));
        triangle.add(List.of(14, 21, 18, 1));

        System.out.println("Result: " + solution.minimumTotal(triangle));
    }
}
