package 二零年五月;

import java.util.ArrayList;
import java.util.List;

/*
    字符串大小全排列：
* 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
输入: S = "3z4"
输出: ["3z4", "3Z4"]
输入: S = "12345"
输出: ["12345"]

思路：采用回溯思想，因为涉及到排列组合的问题，所以 可以这样考虑， 先 判断 a1 ：有 a1 A1 ,然后在其基础上判断 b或者 B ：所以结果有：
 ["a1b2", "a1B2", "A1b2", "A1B2"] 四种，按照这种思路，每一层都尝试向下一层判断，如果判断失败或者重复就返回上一层继续判断该层下一个，
 这就是回朔的思想，可以采用dfs完成.(因为这种思路可以类似于构成一颗二叉树).
* */
public class Leetcode784 {

    public List<String> letterCasePermutation(String S) {
        char[] s=S.toCharArray();
        List<String> list=new ArrayList<>();
        dfs(list,s,0);
        return list;
    }

    private void dfs(List<String> list,char[] s,int index){
        if(index==s.length){ //说明已经匹配到文本串末尾
            list.add(new String(s));
            return;
        }
        //每一层的字符都有两种情况， 更改当前字符为大写或者不变
        dfs(list,s,index+1); //当前字符不变 或者是数字的一条分支

        if (s[index] >'9'){ //如果当前是小写字符，将该字符改成大写
            s[index] ^=32;//s[i]^32 将小写转为大写
            dfs(list,s,index+1);
        }
    }
}
