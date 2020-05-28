package 二零年五月;
/*
    连续子数组的最大和
* 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

思路：使用动态规划, 使用一个一维数组表示dp[i]表示以nums【i】为末位的连续子串的最大和,需要状态定义，转移方程，初始状态,
状态定义：一维数组dp， dp[i]表示以nums【i】为末位的连续子串的最大和

转移方程：当 dp[i - 1] > 0 时：执行 dp[i] = dp[i-1] + nums[i] ；
        当 dp[i - 1] ≤0 时：执行 dp[i] = nums[i] ；

初始状态：dp[0]=nums[0],即以num【0】为结尾的连续子串的和为nums[0]

返回值 ： 返回dp列表中最大的，代表全局最大值

因为dp[i]只与dp[i-1]与num[i]有关，所以直接可以用nums【i】替代，改进maxSubArray
 */

public class View42 {
    //按照动态规划的写法,下面仅适合于正数最大值的情况
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }else if(dp[i-1]<=0){
                dp[i]=nums[i];
            }
        }

        //仅适用于最大值为正数，  要考虑负数最大值，可以先排序dp，然后返回末位的值
        int max=-1;
        for (int i = 0; i <dp.length ; i++) {
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }

    //改进，只用nums[i]
    public int maxSubArray1(int[] nums) {
        int res=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            nums[i] +=Math.max(nums[i-1],0);
            res =Math.max(res,nums[i]);
        }
        return res;
    }
}
