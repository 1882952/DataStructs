package LeetCode1_100;

/**
 * 交错字符串
 *给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 思路：这道题相当于二维数组的最长路径问题，相当于动态规划， 区别在于 dp[i][j] 里保存的是 a中的前i个 与 b中前j个 是否能拼出C中的前i+j个字符
 *
 * 边界条件： dp[0][0] = true;
 *          i =0 的情况下， s2[0,j] 是否 == s3【0，j】 如果有哪一位不相等，结束循环。
 *          j= 0 同理， s1【i，0】 是否 == s3[0,i]  如果有哪一位不相符，结束循环。
 *          一般条件： 就和 求不同的路径和一样，  dp[i][j]  要么是 (i,j-1) 与当前位置比较， 要么是 (i-1.j) 与当前位置的比较
 *    直接写出状态转移方程， dp[i][j] = (dp[i][j-1] && b[j]== c[j+i]) || (dp[i-1][j] && a[i]==c[i+j])
 *  不要浮躁，学了一个多月的动态规划了，这应该是能写出来的，不要先入为主，每道题都要认真反思。
 *
 *      二维数组的概念又迷糊了，记住，数组的数组就是二维数组，  j 个 大小 为 i 的数组
  */
public class L_97交错字符串 {

    public static void main(String[] args) {

    }

    /**
     *
     * @param s1 字符串A
     * @param s2 字符串B
       @param s3  匹配的字符串
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3){
        int m = s1.length() , n = s2.length(), z = s3.length();
        boolean[][] dp = new boolean[m+1][n+1];

        if (s3.length() != m + n) return false;

        //边界条件 ,
        dp[0][0] = true;
        // 构建二维数组，行和列都是从 1开始的。 所以得这么写
        for (int i = 1; i <=m && (s1.charAt(i-1) == s3.charAt(i-1)) ; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j <=n &&  (s2.charAt(j-1) == s3.charAt(j-1)) ; j++) {
            dp[0][j]=true;
        }

        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(j+i-1)) || (dp[i-1][j] && s1.charAt(i-1)== s3.charAt(j+i-1));
            }
        }
        return dp[m][n];
    }
}
