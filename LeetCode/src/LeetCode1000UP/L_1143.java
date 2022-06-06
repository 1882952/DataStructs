package LeetCode1000UP;

/**
 *1143. 最长公共子序列
 *  给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 *  思路，状态转移方程， 分为 nums[i]== nums[j]的情况，dp[i][j]=dp[i-1][j-1]+1,  与 nums[i]!=nums[j]的情况。 dp[i][j] = Math.nax(dp[i-1][j],dp[i][j-1])
 *
 *  还有一点需要注意，dp[i][j] 与 dp[i+1][j+1] 的情况
 */
public class L_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] charsA = text1.toCharArray();
        char[] charsB = text2.toCharArray();
        // 状态转移数组定义比原数组长的情况,这样的好处是不用考虑边界问题
        int[][] dp = new int[charsA.length+1][charsB.length+1];
        for (int i = 1; i <charsA.length+1 ; i++) {
            for (int j = 1; j <charsB.length+1 ; j++) {
                if(charsA[i-1] == charsB[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[charsA.length][charsB.length];
    }
}
