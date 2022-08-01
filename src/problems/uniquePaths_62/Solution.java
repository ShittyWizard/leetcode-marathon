package problems.uniquePaths_62;

public class Solution {
//    3,2 => 3
//    3, 7 => 28
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
//        grid[m-1][n-1] = 1;
//        rows
        for (int i = m-1; i >= 0; i--) {
//            columns
            for (int j = n-1; j >= 0; j--) {
                int right = (j + 1) < n ? grid[i][j+1] : 0;
                int down = (i + 1) < m ? grid[i+1][j] : 0;
                if (right == 0 & down == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = right + down;
                }
            }
        }

        return grid[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 7));
    }
}
