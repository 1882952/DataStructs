package 二零年3月;

import java.util.ArrayList;
import java.util.List;

/*
* 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
示例1:
 输入：S = "qwe"
 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
示例2:
 输入：S = "ab"
 输出：["ab", "ba"]
提示:
字符都是英文字母。
字符串长度在[1, 9]之间。

思路：采用回朔法， 回朔法其实就是对一个树形图进行深度优先遍历,

回朔法来一步步找到没用过的字母迭代，当所有的字母都使用过了，加入到list中

这道题与0804那道求子集的题很像，0804那道是只要没出现，就添加，并且不重用，举个例子：1，2，3，4，
那么就可以为1，  1 2，   1 2 3  ，    1  2  3  4，
   2， 2 3， 2 3 4 .........等等， 即每次进入递归时都需要添加一个结果。

     而这道题是只有迭代完所有元素，才能添加进集合，S中的每个字符都可以作为头结点产生一个树形结构，
 所以判断条件是当迭代代表的指针start等于数组的长度时，才会添加一个结果进入集合，
 而且字符串的元素需要重用，
 所以每次循环都是从0开始的，这就需要一个数组作为判断条件，只有当元素没有使用时，才能进行下一层的递归。

* */
public class InterView0807 {
    public String[] permutation(String S) {
        if (S.length()==0){
            return new String[0];
        }
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        boolean [] userd=new boolean[S.length()];
        backTrank(list,userd,sb,S,0);
        return list.stream().toArray(String[]::new);
    }

    /**
     *
     * @param list   保存结果的集合
     * @param userd  判断s中的元素是否使用过的数组
     * @param sb     保存结果的结构
     * @param s      输入的数组
     * @param start  迭代代表的指针
     */
    private void backTrank(List<String> list,boolean [] userd,StringBuilder sb,String s,int start){
        if (start==s.length()){  //如果迭代到了末尾，才会添加保存的结果sb
            list.add(sb.toString());
        }
        for (int i = 0; i <s.length() ; i++) { //这是与求子集的区别，因为有判断元素是否使用，所以每次进行for循环都可以从0开始判断
            if(!userd[i]){   //s[i]没有使用过才会进行递归
                userd[i]=true; //使用前设置为true
                sb.append(s.charAt(i));
                backTrank(list,userd,sb,s,start+1);
                sb.deleteCharAt(sb.length()-1); //回朔时sb减去最后一位，这样在回朔到头时刚好清空，供下一个元素作为头使用
                userd[i]=false; //回朔后设置s[i]为false供下次使用
            }
        }
    }
}
