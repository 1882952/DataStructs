package 二零年8月;
/*
* 斐波拉契数列
* */
public class S10_1 {

    //动态规划 dp[i]=dp[i-1]+dp[i-2]
    public int fib(int n){
        if(n==0){
            return 0;
        }
        //一维数组dp，dp[i]值代表斐波那契第i个数字
        int[] dp=new int[n+1];
        //初始状态
        dp[0]=0;
        dp[1]=1;
        //动态规划过程
        for (int i = 2; i <=n ; i++) {
            dp[i]=(dp[i-2]+dp[i-1])%1000000007;
        }
        return dp[n];
    }


    //递归，但是测试会溢出，所以采用上述的动态规划
    public int fib1(int n) {

        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        return (fib1(n-2)+fib1(n-1))%1000000007;
    }
}
