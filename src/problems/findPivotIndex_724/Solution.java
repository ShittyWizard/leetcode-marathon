package problems.findPivotIndex_724;


import java.util.Arrays;

// link : https://leetcode.com/problems/find-pivot-index/
public class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum() - nums[0];
        if (leftSum == rightSum) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i-1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pivotIndex(new int[] {1,7,3,6,5,6}));
    }

    /*
        Input: nums = [1,7,3,6,5,6]
        Output: 3

        Input: nums = [1,2,3]
        Output: -1

        Input: nums = [2,1,-1]
        Output: 0
     */
}
