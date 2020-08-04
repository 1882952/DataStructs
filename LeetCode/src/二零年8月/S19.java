package 二零年8月;
/*
    正则表达式的匹配
* 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
* 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

    思路：可以从动态规划与递归两种思路去解析：
        这里使用动态规划：
    一：转移方程：
       f[i][j] 代表 A 的前 i 个和 BB 的前 j 个能否匹配

    对于前面两个情况，可以合并成一种情况 f[i][j] = f[i-1][j-1]

    对于第三种情况，对于 c∗ 分为看和不看两种情况：
    不看：直接砍掉正则串的后面两个， f[i][j] = f[i][j-2]
    看：正则串不动，主串前移一个，f[i][j] = f[i-1][j]

    二：初始条件：
    特判：需要考虑空串空正则
    空串和空正则是匹配的，f[0][0] = truef[0][0]=true
    空串和非空正则，不能直接定义 truetrue 和 falsefalse，必须要计算出来。（比如A=A= '' '' ,B=a*b*c*B=a∗b∗c∗）
    非空串和空正则必不匹配，f[1][0]=...=f[n][0]=falsef[1][0]=...=f[n][0]=false
    非空串和非空正则，那肯定是需要计算的了。
* */
public class S19 {
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        boolean[][] f=new boolean[n+1][m+1];
        for (int i = 0; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {
                //分为空正则与非空正则
                if(j==0){
                    f[i][j]=i==0;
                }else {
                    //非空正则分为两种情况 * 与非 *
                    if(p.charAt(j-1)!='*'){
                        if(i>0 && ((s.charAt(i-1)==p.charAt(j-1)) || p.charAt(j-1)=='.')){
                            f[i][j]=f[i-1][j-1];
                        }
                    }else { //碰到 * 了。分为看 与 不看两种情况
                        if(j>=2){ //不看 ,
                            f[i][j] |= f[i][j-2];
                        }
                        //看
                        if(i>=1 && j>=2 &&((s.charAt(i-1)==p.charAt(j-2)) || p.charAt(j-2)=='.')){
                            f[i][j] |=f[i-1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
