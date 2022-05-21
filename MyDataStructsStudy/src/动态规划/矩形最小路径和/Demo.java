package 动态规划.矩形最小路径和;

/**
 * 题目：
 * 给定一个，包含非负整数的 m x n 网格。请找出一条，从左上角到右下角的路径。使得路径上，所有数字总和为最小，每次只能向下，或者向右移动一步。
 * 输入:[[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 思路： 这道题就成了二维的情况，但是没关系，我们继续按照每一步的最优解分析，
 * 二维数组nums[i,j]，那么就有三种情况， 仅i++，j==0,  那么就是前一步的dp[i-1][0]+当前值grid[i][0]
 *                                  仅j++，i==0， 那么就是前一步的dp[0][j-1]+当前值grid[0][j]
 *                                  当i和j都变化时，要么就是dp[i-1][j]+grid[i][j],要么就是dp[i][j-1]+grid[i][j],就这两个值,取最小值
 *
 *      所以，这个问题就解决了，这也是最简单的二维动态规划问题
 *      问题 ： 二维数组 A[m][n] 代表 m 行， n列 ，谨记，刚才写的完全错了
  */
public class Demo {
    /**
     * 二维数组
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid[0].length][grid.length];
        // 0.0原点的值
        dp[0][0] = grid[0][0];
        //仅横向i++的值， 第0 列，只有i++
        for (int i = 1; i <grid.length ; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        //仅纵向j++的值, 第0行，只有j++
        for (int j = 1; j <grid[0].length; j++) {
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }

        for (int i = 1; i <grid.length ; i++) {
            for (int j = 1; j <grid[0].length ; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public int explame(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
