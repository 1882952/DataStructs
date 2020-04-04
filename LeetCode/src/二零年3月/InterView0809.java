package 二零年3月;

import java.util.ArrayList;
import java.util.List;

/*
* 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
说明：解集不能包含重复的子集。
例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

思路：这道题是属于递归，可以考虑左括号和右括号，就相当于左右子节点一样递归
* */
public class InterView0809 {

    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        if (n==0){
            return list;
        }
        generator(list,"",n,0,0);
        return list;
    }

    /**
     * @param list  需要返回的集合
     * @param item  每一个值
     * @param n     括号的对数
     * @param left  左指针
     * @param right 右指针
     */
    public void generator(List<String> list,String item,int n,int left,int right){
        if((left+right)==2*n){
             list.add(item);
             return;
        }
        if (left<n){
            generator(list,item+"(",n,left+1,right);
        }
        if((right<n) && right<left){
            generator(list,item+")",n,left,right+1);
        }
    }
}
