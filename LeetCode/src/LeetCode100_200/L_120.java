package LeetCode100_200;

import java.util.List;

/**
 * 三角形最小路径和
 *
 *  思路 ； 这题比较简单， 就是动态规划，  也可以构成一个二维数组， dp[i][j] = Math.min (dp[i+1][j],dp[i+1][j+1])+nums[j]
    因为求最小路径和， 并且状态转移方程 由 i+1 决定 i, 所以倒着循环，刚好到第0位是1，也满足递归条件。
 */
public class L_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        // 状态转移空间还是设置为 n * n 的形式
        int dp [][] = new int[n+1][n+1];

        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
