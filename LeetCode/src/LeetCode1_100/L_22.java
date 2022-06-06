package LeetCode1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  思路： 这道题并不适合于使用动态规划，更加像一个利用一个数学归纳法得到递推公式的过程，所以更适合用递归和回溯解决该问题。
 *
 *   这道题通过回溯分析更容易解决，  因为 有 n个括号对，所以使用  n， n 代表左括号和右括号的数量，  通过画图， 比较 （n,n） 每次剩余多少，
 *
 *   利用 n==2， n==3 , 画出回溯二叉树（每一次判断 加 （  还是加 ） ）就可以得出规律，写出代码。   相当于深度优先回溯
 */
public class L_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("",n,n,res);
        return res;
    }

    private void dfs(String str,int left,int right,List<String> res){
        //判断 递归头， 即 n==0的情况
        if(left ==0 && right == 0){
            res.add(str);
            return;
        }

        if(left == right){ // 这种情况只能 str+(
            dfs(str+"(",left-1,right,res);
        }else if(left < right){ // 既可以加 ( 也可以加 ) , 加 （ 只要left >0
            if(left>0){
                dfs(str+"(",left-1,right,res);
            }
            // 加右括号
            dfs(str+"）",left,right-1,res);
        }
    }
}
