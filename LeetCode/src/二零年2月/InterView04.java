package 二零年2月;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
* 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
回文串不一定是字典当中的单词。

示例：

输入：Tact Coa
输出：True（排列有"taco cat"、"atco cta"，等等）
* */
public class InterView04 {
    public boolean canPermutePalindrome(String s) {
        //每个字符出现的次数为偶数，或者有且只有一个字符为奇数，就可以构成回文数，可利用set集的去重思路解决
        Set<Character> set=new HashSet<>();
        for (char c : s.toCharArray()) {
            if(!set.add(c)){
                set.remove(c);
            }
        }
        return set.size()<=1;
    }
}
