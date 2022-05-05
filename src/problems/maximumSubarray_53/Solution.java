package problems.maximumSubarray_53;

public class Solution {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = new int[]{1};
        int[] nums3 = new int[]{5,4,-1,7,8};
        System.out.println(maxSubArray(nums1)); // 6
        System.out.println(maxSubArray(nums2)); // 1
        System.out.println(maxSubArray(nums3)); // 23
    }
}
