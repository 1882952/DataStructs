package 二零年3月;
/*
* 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
* 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
示例1:
 输入：n = 3
 输出：4
 说明: 有四种走法
示例2:
 输入：n = 5
 输出：13

思路：利用动态规划， f(n)=f(n-1)+f(n-2)+f(n-3) ,n>=3 ,所以取出前三位，然后利用这一公式解决，注意，需要
取模
* */
public class InterView0801 {
    private static final int MOD=1000000007;
    public int waysToStep(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }

        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        dp[2]=4;
        //利用公式后取模
        for (int i = 3; i <n ; i++) {
            dp[i] =
                    ((dp[i-1]%MOD + dp[i-2]%MOD)%MOD+dp[i-3]%MOD)%MOD;
        }
        return dp[n-1];
    }
}
