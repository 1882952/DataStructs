package 二零年3月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。

示例1:
 输入：S = "qqe"
 输出：["eqq","qeq","qqe"]
示例2:
 输入：S = "ab"
 输出：["ab", "ba"]
提示:
字符都是英文字母。
字符串长度在[1, 9]之间。

思路；可以和0807即上一道求无重复字符串的排列组合作为对比
    因为有重复的字符，所以可以先选择将数组排序，然后再进行回朔
关键点是需要判断重复字符问题,那么就需要每次保存上一位判断,因为是排序过的S，所以当前位字符作根节点
时与上一位相同，就跳过
* */
public class InterView0808 {
    public String[] permutation(String S) {
        if(S.length()==0){
            return new String[0];
        }
        //需要先对S进行排序
        char[] chars=S.toCharArray();
        Arrays.sort(chars);

        List<String> list=new ArrayList<>();
        boolean[] userd=new boolean[chars.length];
        StringBuilder sb=new StringBuilder();
        backTrank(list,userd,sb,chars,0);
        return list.stream().toArray(String[]::new);
    }
     public void backTrank(List<String> list,boolean[] userd,StringBuilder sb,char [] s,int start){
        if (start==s.length){
            list.add(sb.toString());
        }
         char lastChar=' ';  //保存上一位的字符
         for (int i = 0; i <s.length ; i++) {
             if(!userd[i] && (s[i]!=lastChar)){  //需要当前字符不等于上一个字符
                sb.append(s[i]);
                userd[i]=true;
                backTrank(list,userd,sb,s,start+1);
                lastChar=s[i];  //在回朔时保存上一位的字符
                userd[i]=false;
                sb.deleteCharAt(sb.length()-1);
             }
         }
     }
}
