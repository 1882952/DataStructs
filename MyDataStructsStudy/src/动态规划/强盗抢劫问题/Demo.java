package 动态规划.强盗抢劫问题;

/**
 * 题目：强盗抢劫一排房间，每个房间都有钱，不能抢劫两个相邻的房间，要求抢的钱最多。数组如：[2,7,9,3,1]
 *
 * 思路： 从第0间房开始，最优解就是第0间房       dp[0]
 *       第1间房，因为不能相邻，所以最优解就是 max(0,1)  dp[1]
 *       第2间房，因为不能相邻，所以最优解就是  max(0+2，1)  dp[2]
 *       第3间房，0,1，2,3   max(3+1,2+0)   dp[3]
 *       第4间房 0,1,2,3,4  第3间房的情况+第4间房，第四间的抢与不抢， 用最大值分这两个情况，max(4+2+0,dp3)   现在就可以推导出来了，
 *
 *      公式如下 ： 设第 i间房子，  dp[i] = max(num[i]+dp[i-2],dp[i-1]).
 *
 *      状态转移方程都出来了，那么代码就很好写了
 *
 */
public class Demo {

    /**
     * @param nums 代表房间前数
     * @return
     */
    public int dynamic(int[] nums){
        int[] dp = new int[nums.length+1];
        //先来特殊情况
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
       // dp[2] = Math.max(nums[0]+nums[2],nums[1]);  // 其实也可以为公式,注释
        for (int i = 3; i <nums.length ; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
