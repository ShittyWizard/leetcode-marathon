package problems.missingNumber_268;

import java.util.Arrays;

// link : https://leetcode.com/problems/missing-number/
class Solution {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int arithmeticSum = n * (n + 1) / 2;
        return arithmeticSum - sum;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,0,1};
        int[] nums2 = new int[]{0,1};
        int[] nums3 = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums1)); // 2
        System.out.println(missingNumber(nums2)); // 2
        System.out.println(missingNumber(nums3)); // 8
    }
}
