package 剑指Offer;

/**
 * 10- I. 斐波那契数列
 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）

    递推关系式： f(n) = f(n-1) +fn(n-2) , 通过这个，递归代码很容易就写出来 , 但是提交超时，所以还是得用动态规划

    也可以搞成状态转移方程： dp[i] = dp[i-1] + dp[i-2]
 */
public class S010_1 {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }


    public int fib1(int n){
        if(n == 0){
            return 0;
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <=n ; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
