package 剑指Offer;

/**
 * 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 思路：和斐波那契数列一样，就是递归规则发生了变化，但还是一致的，
 *      此题的跳法有两种， 只跳一个台阶， f(n-1)
 *                      只跳两个台阶， f(n-2)
 * f(n) 就是这两个相加， f(n) = f(n-1) + f(n-2)
 */
public class S010_2 {
    public int numWays(int n) {
        if(n == 0){
            return 0;
        }
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <=n ; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
