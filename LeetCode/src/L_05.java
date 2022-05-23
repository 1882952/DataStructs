/*
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
输入: "cbbd"
输出: "bb"

解决这类问题的核心思想就是两个字“延伸”，具体来说
如果一个字符串是回文串，那么在它左右分别加上一个相同的字符，那么它一定还是一个回文串
如果一个字符串不是回文串，或者在回文串左右分别加不同的字符，得到的一定不是回文串
事实上，上面的分析已经建立了大问题和小问题之间的关联， 基于此，我们可以建立动态规划模型。
我们可以用 dp[i][j] 表示 s 中从 i 到 j（包括 i 和 j）是否可以形成回文， 状态转移方程只是将上面的描述转化为代码即可：
if (s[i] = s[j] && dp[i + 1][j - 1]) {
  dp[i][j] = true;
}
* */
public class L_05 {
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0){return s;}
        String res="";
        char[] chars=s.toCharArray();
        boolean [][] dp=new boolean[s.length()][s.length()];  //动态规划判断dp[i][j]
        //根据公式，知道了i+1才会知道i，所以倒着遍历就行
        for (int i=s.length()-1;i>=0;i--){
            for (int j = i; j <s.length(); j++) {
                if(j-i==0){  //说明i与j指针指向同一个位置
                    dp[i][j]=true;
                }else if(j-i==1 && chars[i]==chars[j]){  //aa特殊形式的回文串
                    dp[i][j]=true;
                }else if (chars[i]==chars[j] && dp[i+1][j-1]){  //即规则
                    dp[i][j]=true;
                }

                if(dp[i][j] && j-i+1>res.length()){  //更新最长回文串
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}
