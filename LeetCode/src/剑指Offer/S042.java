package 剑指Offer;

import java.util.Arrays;
import java.util.List;

/**
 * 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 思路： 将这个数组转为二维数据， 那么 [i,j] 就是 [i,j] 区间的和，
 *       遍历到末尾，求出最大和就行
 *       状态转移方程 ： result = Math.max(dp[i][j],result) , 这个思路不对
 *
 *   这个思路是正确的， dp[i] = Math.max(num[i],dp[i-1]+nums[i])
 *      dp[i] 代表的是前i个数组最大子序列的和的值，这样就是比较清晰的， 也可以推导，dp[0] ， dp[1] 代表的的含义
 */
public class S042 {

    // 此代码错误，考虑复杂了， 其实用 dp[i] 代码前i个子序列和的最大值就行
//    public int maxSubArray1(int[] nums) {
//        if(nums.length<1){
//            return -1;
//        }
//        int result = nums[0];
//        int dp[][] = new int[nums.length][nums.length];
//        // 初始化状态
//        for (int i = 0; i <dp.length ; i++) {
//            dp[i][0] = nums[i];
//        }
//        for (int j = 0; j <dp[0].length ; j++) {
//            dp[0][j] = nums[j];
//        }
//
//        for (int i = 1; i <nums.length ; i++) {
//            for (int j = i; j <nums.length ; j++) {
//                int arrayValue = 0;
//                for (int k = i; k <=j ; k++) {
//                    arrayValue+=nums[k];
//                }
//                dp[i][j] = arrayValue;
//                result = Math.max(result,dp[i][j]);
//            }
//        }
//        return result;
//    }

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
