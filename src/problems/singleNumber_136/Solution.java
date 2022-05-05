package problems.singleNumber_136;

// link : https://leetcode.com/problems/single-number/
public class Solution {
    public static int singleNumber(int[] nums) {
        int mask = 0;
        for (int num : nums) {
            mask = mask ^ num;
        }
        return mask;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,2,1};
        int[] nums2 = new int[]{4,1,2,1,2};
        int[] nums3 = new int[]{1};
        System.out.println(singleNumber(nums1)); // 1
        System.out.println(singleNumber(nums2)); // 4
        System.out.println(singleNumber(nums3)); // 1
    }
}
