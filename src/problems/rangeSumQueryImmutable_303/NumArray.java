package problems.rangeSumQueryImmutable_303;

import java.util.ArrayList;
import java.util.List;

// link : https://leetcode.com/problems/range-sum-query-immutable
public class NumArray {
//    int[] nums;
    List<Integer> sums = new ArrayList<>();

    public NumArray(int[] nums) {
//        this.nums = nums;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            sums.add(sum);
        }
        System.out.println("sum " + sums);
    }

    public int sumRange(int left, int right) {
//        int sum = 0;
//        for (int i = left; i <= right; i++) {
//            sum += nums[i];
//        }
//        return sum;
        if (left == 0) {
            return sums.get(right);
        }
        return sums.get(right) - sums.get(left - 1);
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2)); // 1
        System.out.println(numArray.sumRange(2, 5)); // -1
        System.out.println(numArray.sumRange(0, 5)); // -3
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
