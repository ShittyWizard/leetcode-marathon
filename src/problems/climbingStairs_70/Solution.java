package problems.climbingStairs_70;

// link : https://leetcode.com/problems/climbing-stairs/
public class Solution {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int n1 = 1;
        int n2 = 2;

        for (int i = 3; i < n + 1; i++) {
            int temp = n1;
            n1 = n2;
            n2 = temp + n2;
        }
        return n2;
    }

    public static void main(String[] args) {
        int num1 = 2;
        int num2 = 3;
        System.out.println(climbStairs(num1)); // 2
        System.out.println(climbStairs(num2)); // 3
    }
}
