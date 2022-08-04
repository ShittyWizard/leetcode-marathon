package problems.kthSmallestElementInTheSortedMatrix_378;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(value -> value));
        for (int[] row : matrix) {
            for (int val : row) {
                queue.add(val);
            }
        }
        int next = 0;
        for (int i = 1; i <= k; i++) {
            if (queue.peek() != null) {
                next = queue.poll();
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        13
        System.out.println(solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
//        1
        System.out.println(solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 1));
//        7
        System.out.println(solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 3));
//        11
        System.out.println(solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 5));
        System.out.println(solution.kthSmallest(new int[][]{{1, 2}, {1, 3}}, 2));
    }
}
