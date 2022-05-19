package problems.binarySearch_704;

// link : https://leetcode.com/problems/binary-search/
public class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int midIndex = start + (end - start) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            } else {
                if (nums[midIndex] > target) {
                    end = midIndex - 1;
                } else {
                    start = midIndex + 1;
                }
            }
        }
        return -1;
    }
}
