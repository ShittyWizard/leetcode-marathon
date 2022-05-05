package problems.countingBits_338;

import java.util.Arrays;

// link : https://leetcode.com/problems/counting-bits
public class Solution {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i >> 1] + i % 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 5;
        System.out.println(Arrays.toString(countBits(n1))); // [0,1,1]
        System.out.println(Arrays.toString(countBits(n2))); // [0,1,1,2,1,2]
    }
}
