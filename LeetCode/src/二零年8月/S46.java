package 二零年8月;

/**数字翻译为字符串
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法

 思路： 0--25 是字母范围，所以数字划分时只要在这个范围内的都可以，比如 ： 115 ： 可以划分为 1,1,5 对应的字符， 11,5对应的字符，1,15对应的字符
      所以，只要划分时有新的数字排列出现，就可以认为是一个字符串 ，而根据上分析，当前划分可以由之前的划分决定，所以可以用动态规划。
      因为翻译的每一次最多只能有两位，所以 有：如果当前位前面的数字可以一起被翻译（能两位一起）， f(i)=f(i-2) + f(i-1)
                                        如果不能被翻译（只能一位）， f(i)=f(i-1)
        得到了状态转移方程，就可以写动态规划
 */
public class S46 {
    public int translateNum(int num) {
        String  str=String.valueOf(num);
        //状态数组
        int dp[]=new int[str.length()+1];
        //初始化
        dp[0]=1;
        dp[1]=1;

        for (int i = 2; i <=str.length() ; i++) {
            String temp=str.substring(i-2,i); //截取两位数字
            if(temp.compareTo("10")>=0 && temp.compareTo("25")<=0){
                dp[i]=dp[i-2]+dp[i-1];
            }else {
                dp[i]=dp[i-1];
            }
        }
        return dp[str.length()];
    }
}
