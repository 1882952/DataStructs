package 二零年五月;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
    词典中最长的单词
* 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
* 若其中有多个可行的答案，则返回答案中字典序最小的单词。
若无答案，则返回空字符串。
示例 1:

输入:
words = ["w","wo","wor","worl", "world"]
输出: "world"
解释:
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。

思路；可以构建一棵字典树trie，然后选取最长的链，但是这种构建字典树的方式太麻烦
所以采用数组排序+set存之前的字符串+compareTo比较字典序
* */
public class LeetCode720 {
    public String longestWord(String[] words) {
        Set<String> set=new HashSet<>();
        Arrays.sort(words, new Comparator<String>() { //排序(按字符串长短排序)
            @Override
            public int compare(String o1, String o2) { //比较规则是两字符串长度的大小
                return o1.length()-o2.length();
            }
        });
        String res="";
        for (String word:words){
            //如果word的长度小于等于1， 或者set集合中包含word的前缀部分，那么就直接将word添加进set
            if(word.length()<=1 || set.contains(word.substring(0,word.length()-1))){
                set.add(word);
                                                                                //word的值小于res
                if(word.length()>res.length() || (word.length()==res.length() && word.compareTo(res)<0)){ //更新最长的字符串
                    res=word;
                }
            }
        }
        return res;
    }
}
