package LeetCode300_400;

/**
 * 求最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 思路：仍然使用动态规划的思路， 将 这个数组转化为一个二维数组，然后一步一步地去分析。 实际上可以转为一维数组, 也可以构成i与j。
 *
 *  得到状态转移方程就可以写代码。  状态转移方程： dp[i] = Math.max(dp[i],dp[j]+1) , 其中 0<j<i
 *
 */
public class L_300 {
    public int lengthOfLIS(int[] nums) {
       if(nums.length == 0){
           return -1;
       }
       int[] dp = new int[nums.length];
       int res =1;
       dp[0] = 1;

        for (int i = 0; i <nums.length ; i++) {
            dp[i] =1;  // 先预置数据，相当于二维数据的第0行
            for (int j = 0; j <i ; j++) {
                if(nums[i]>nums[j]){ // 证明递增的.因为每次都是从0位开始，只有连续递增，才能连续的dp[j]+1。
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
