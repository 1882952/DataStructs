package 二零年2月;

import java.util.HashMap;
import java.util.Map;

/*
* 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
示例 1：
输入: s1 = "abc", s2 = "bca"
输出: true
示例 2：
输入: s1 = "abc", s2 = "bad"
输出: false
* */
public class Interview02 {
    public boolean CheckPermutation(String s1, String s2) {
        //思路，用hashmap
        if(s1.length()!=s2.length()){
            return false;
        }
        //用hashmap存储其中一个s
        Map<Character,Integer> charmap=new HashMap<>();
        for (char c : s1.toCharArray()) {
            if(charmap.containsKey(c)){
                int i=charmap.get(c);
                charmap.put(c,++i);
            }else {
                charmap.put(c,1);
            }
        }
        //比较
        for (int i = 0; i <s2.length() ; i++) {
            if(charmap.containsKey(s2.charAt(i))){
                int j=charmap.get(s2.charAt(i));
                charmap.put(s2.charAt(i),--j);
                if(j<0){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
    //第二种思路，简单粗暴，直接用ASC码总值
    public boolean CheckPermutation1(String s1, String s2) {
        int sum1=0;
        int sum2=0;
        if(s1.length()!=s2.length()){
            return false;
        }
        for (int i=0;i<s1.length();i++){
            sum1+=s1.charAt(i);
            sum2+=s2.charAt(i);
        }
        if(sum1==sum2){
            return true;
        }
        return false;
    }
}
