package 二零年6月;
/*
* 判断子序列
*给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
示例 1:
s = "abc", t = "ahbgdc"
返回 true.
示例 2:
s = "axc", t = "ahbgdc"
返回 false.
*
* 思路： java中非常好的一个方法，indexOf(char c,int m)意思是从第m位置开始寻找该索引，找到则返回该索引，否则返回-1，利用该特性我们通过对索引
* 处理从而获得解。 还可以利用双指针，遍历主字符串比较， 或者可以使用map保存主字符串的子序列（子串的长度），然后查找map即可。
*
* 要练习动态规划，所以以动态规划的思路求解：
*   思路：状态 :dp[i][j] 代表为子串s的从头开始到i的字符串是否为主t从头开始到j的子字符串的子序列
*        状态转移公式：
*           - 当char[i]==char[j] 时，则字符i一定是字符j的子序列,如果此时0~i-1字符串是0~j-1子字符串的子序列,则dp[i][j]=true,
*           所以dp[i][j]=dp[i-1][j-1]。
*           - 当char[i]！=char[j]时，即需要判断当前0~i子字符串是否为0~j-1子字符串的子序列，即dp[i][j]=dp[i][j-1],
*           比如：如ab，eabc，虽然s的最后一个字符b和t中最后一个字符c不相等，但是因为ab是eab的子序列，所以ab也是eabc的子序列
*       初始化：空字符串一定是t的子字符串的子序列，所以dp[0][j]=true ,主串为空字符串一定没有子序列,所以dp[i][0]=false;
*       结果：返回dp[slen][tlen]
* */
public class LeetCode392 {
    //使用indexof的方式解决
    public boolean isSubsequence(String s, String t) {

        char[] c=s.toCharArray();
        int j=-1;

        for (int i = 0; i <c.length ; i++) {
            j=t.indexOf(c[i],j+1);
            if(j==-1){
                return false;
            }
        }
        return true;
    }

    //使用动态规划求解 ,s:子串， t：主串
    public boolean isSubsequence1(String s, String t) {
        int sLen=s.length(),tLen=t.length();
        if(s.length()>t.length()){
            return false;
        }
        if(s.length()==0){
            return true;
        }

        boolean[][] dp=new boolean[sLen+1][tLen+1];
        //初始化
        for (int j = 0; j <tLen ; j++) {
            dp[0][j]=true; //空字符串一定是t的子字符串的子序列，所以dp[0][j]=true
        }
        for(int i = 1;i<= sLen;i++){
            dp[i][0] = false; //主串为空字符串一定没有子序列,所以dp[i][0]=false;
        }

        //dp
        for (int i = 1; i <=sLen ; i++) {
            for (int j = 1; j <=tLen ; j++) {
                if(s.charAt(i-1)==t.charAt(j-1)){ //char[i]==char[j]
                    dp[i][j]=dp[i-1][j-1];
                }else {//char[i]!=char[j]
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
