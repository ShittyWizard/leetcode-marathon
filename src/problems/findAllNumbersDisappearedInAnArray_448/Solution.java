package problems.findAllNumbersDisappearedInAnArray_448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// link : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class Solution {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        first solution
//        List<Integer> resultList = new ArrayList<>();
//        int[] resultArray = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            resultArray[i] = i + 1;
//        }
//        for (int num : nums) {
//            resultArray[num-1] = 0;
//        }
//        for (int num : resultArray) {
//            if (num != 0) {
//                resultList.add(num);
//            }
//        }
//        return resultList;

//        cyclic sort
        int i = 0;
        while (i < nums.length) {
            int pos = nums[i] - 1;
            if (nums[i] != nums[pos]) {
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
            } else {
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(j + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,3,2,7,8,2,3,1};
        int[] nums2 = new int[]{1,1};
        System.out.println(findDisappearedNumbers(nums1)); // [5, 6]
        System.out.println(findDisappearedNumbers(nums2)); // [2]
    }
}
