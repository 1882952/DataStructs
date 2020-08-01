package 二零年8月;

import java.util.HashMap;
import java.util.Map;

/*
* 青蛙跳台阶问题
* 可以跳一层 也可以跳二层,总共有多少种跳法
*
* 解决方式，递归，或者动态规划
* */
public class S10_2 {
    Map<Integer,Integer> map=new HashMap<>();
    //递归法，但是直接使用递归会超时，因为会有许多重复的计算，所以需要使用一个集合把重复的保存起来
    public int numWays(int n) {
        if(n<=1){
            return 1;
        }
        //如果计算过，则直接返回
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            map.put(n,(numWays(n-1)+numWays(n-2))%1000000007);
            return map.get(n);
        }
    }
    //使用动态规划 dp[i]=dp[i-1]+dp[i-2]
    public int num(int n){
        if(n<=1){
            return 1;
        }
        int []dp=new int[n+1];
        //初始化
        dp[0]=1;dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
