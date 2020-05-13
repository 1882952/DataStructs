package 二零年五月;
/*
* 给定一个整数数组，找出总和最大的连续数列，并返回总和。
示例：
输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
* 思路：使用动态规划解决问题，
* 我们新建一个数组dp[len]，来保存状态。
- dp[i]表示，从0到i，在包含元素i的情况下的最大值
- dp[0] = nums[0]
- dp[i] = max(nums[i],dp[i-1] + nums[i])
- 找到dp中的最大值即可
* */
public class InterView1617 {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if(len==0){
            return 0;
        }
        if(len==1){
            return nums[0];
        }
        int[] dp=new int[len];
        dp[0]=nums[0];
        int max=dp[0];
        //dp[i]表示从左到右，包含num[i]的最大值。
        for (int i = 1; i <len ; i++) {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        //找到最大值
        for (int i=0;i<dp.length;i++){
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
