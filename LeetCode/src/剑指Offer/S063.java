package 剑指Offer;

/**
 * 剑指 Offer 63. 股票的最大利润
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *  思路 ： 通过数学归纳法推导出递归公式，实际上就是以第i天为起点，遍历第i+1天的情况，求出最大利润，然后再与之前的最大利润比较，取最大的
 *
 *         result = Math.max(dp[i],result).
 */
public class S063 {
    public int maxProfit(int[] prices) {
        int result = 0;
        if(prices.length<1){
            return result;
        }

        for (int i = 0; i < prices.length ; i++) {
            int tmp = 0;
            for (int j = i; j <prices.length ; j++) {
                if(prices[j]>prices[i]){
                    tmp = Math.max(tmp,prices[j]-prices[i]);
                }
            }
            result = Math.max(result,tmp);
        }
        return result;
    }
}
