package 二零年8月;

/**
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *思路：对于最优选择的问题，第一时间想到动态规划
 *     可以想到 ： 前i日最大利润= 前 i-1 日最大利润 与 第 i 日卖出的最大利润 中的 最大值
 *
 *     利用这个转移状态思路，可以轻松写出代码
 */
public class S63 {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int res=0,min=prices[0]; // min默认为最小的股票价格 ，res：前i-1日的最大利润
        for (int i = 1; i <prices.length ; i++) {
            min=Math.min(prices[i-1],min);
            res=Math.max(res,prices[i]-min);  // 这句就是转移方程
        }
        return res;
    }
}
