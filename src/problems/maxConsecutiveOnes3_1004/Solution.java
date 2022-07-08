package problems.maxConsecutiveOnes3_1004;

// link : https://leetcode.com/problems/max-consecutive-ones-iii/
public class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int left = 0;
        int zeros = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                while (zeros >= k) {
                    if (nums[left] == 0) {
                        zeros--;
                    }
                    left++;
                }
                zeros++;
            }
            if (max < right - left + 1) {
                max = right - left + 1;
            }
        }
        return max;
    }
}
