package 二零年8月;

/** 丑数的个数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 思路：使用动态规划, 所有的数（1除外）都是2，3或者5的倍数，所以可以利用倍数关系递推解决。
 */
public class S49 {
    public int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int [] dp=new int[n];
        //初始化 第1个数
        dp[0]=1;

        for (int i = 1; i <n ; i++) {
            int n2=dp[a]*2,n3=dp[b]*3,n5=dp[c]*5;
            dp[i]=Math.min(Math.min(n2,n3),n5);
            if(dp[i]==n2){
                a++;
            }
            if(dp[i]==n3){
                b++;
            }
            if(dp[i]==n5){
                c++;
            }
        }
        return dp[n-1];
    }
}
