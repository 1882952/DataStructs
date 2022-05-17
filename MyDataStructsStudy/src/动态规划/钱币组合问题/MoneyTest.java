package 动态规划.钱币组合问题;

import java.util.ArrayList;

/**
 * 钱币组合问题
 *  给定总金额和可能的钱币面额，能否找出钱币数量最少的奖赏方式？
 *
 *  思想： 动态规划适用于解最优解的问题， 凡是问题中出现最优情况的，首先要想到的是动态规划；
 *  假设这里我们有三种面额的钱币，2 元、3 元和 7 元。为了凑满 100 元的总金额 ， 为了凑满100元，有三种情况：
 *  第一种， 总和 98元的硬币 加 1枚两元硬币，  (x1+1)个
 *  第二种， 总和为97的银币 加 1枚3元硬币， (x2+1)个
 *  第三种， 总和为 93的硬币， 加1枚7元硬币， (x3+1) 个

    所以 状态转移方程为 c[i] = min(c[i-value[j]]+1), c[i]表示总额为 i 的时候，所需要的最少钱币数，其中 j=1,2,3,…,n，表示 n 种面额的钱币
        不用考虑其余特殊情况， 因为 如果 i-value【j】 小于0， 数组默认值是0；
 */
public class MoneyTest {

    /**
     *
     * @param money 面值
     * @param coins 硬币面值数组
     * @return
     */
    public static int Count(int money,int[] coins){
        if(money<0){
            return -1;
        }
        // 状态数组， 保存每一个面值当前所需的最优纸币数 ， 下标：当前面值， 值：最优纸币数
        int[] dp = new int[money+1];
        int[] t =new int[3]; // 保存每个币值的次数
        for (int i = 0; i <money ; i++) {  // 0~99 次循环 ，100块纸币 , 或者直观点，从1开始，100结束
            for (int j = 0; j <coins.length ; j++) { // 内循环相当于将每一个面值 减去 2 ，3 ，7 三种情况
                if(i - coins[j] >=0){ // 证明匹配 或者 还有剩余值
                    t[j] = dp[i-coins[j]+1]+1;
                }
            }
            // 每次都要取一个最优解
            int min = Math.min(t[0],t[1]);
            min = Math.min(min,t[2]);
            dp[i+1] = min;
        }
        return dp[money];
    }

    public static void main(String[] args) {
        int c = 100;
        int[] value = new int[] { 2, 3, 7 };
        System.out.println(Count(100, value)+1);
    }
}
