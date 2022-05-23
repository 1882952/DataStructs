package LeetCode1_100;

/**
 * 最长回文串
 * 思路：最长，求最优解，想到动态规划，然后分析求解。
 * 根据回文的思路分析:
 *  创建一个二维动态分析数组，dp[i][j] , 表示 i，j区间是否为回文串；
 *  对于基本情况的分析， 1： 如果 i==j，在同一个位置，那么dp[i][j]=true;
 *                   2: 如果 i+1==j，相邻，且元素相等，那么dp[i][j] = true;
 *                   3: 如果 i和j之间中间隔着字符或字符串，但i，j上的字符相等，那么只要判断 中间的字符串或字符是否回文，那么dp[i][j]肯定回文。 这也是状态转移方程 dp[i][j] == true(i,j)+dp[i+1][j-1]
 *                      因为是这个公式，所以循环的时候要注意以下，i从大到小，因为要获取i+1. j从小到达，但起始点是 i。
 *     按照这个逻辑，定义一个临时变量res，实时更新符合条件的最长字符串，就能写出代码.
 */
public class L_05 {

    public String longestPalindrome(String s) {
        if(s.length()==0){
            return s;
        }
        // 定义状态数组
        boolean[][] dp = new boolean[s.length()][s.length()];

        String res = "";

        // i == 0 的那一列全为true
        for (int j = 0; j <dp.length ; j++) {
            dp[0][j]=true;
        }
        // 相当于循环遍历两次数组
        for (int i = s.length()-1; i >=0; i--) {
            for (int j = i; j <s.length() ; j++) {
                // 三种情况的实现
                if(j-i== 0){
                    dp[i][j] = true;
                }else if(j-i ==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                }else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                }
                if(dp[i][j] && j-i+1>res.length()){ // 满足这个条件就更新
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }

}
