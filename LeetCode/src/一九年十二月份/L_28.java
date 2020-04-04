package 一九年十二月份;
/*
* 实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

* */
public class L_28 {
    public int strStr(String haystack, String needle) {
        int[] next=kmpNext(needle);
        for (int i = 0,j=0; i <haystack.length() ; i++) {
            //需要处理str1.charAt(i)!=str2.charAt(j)的情况，去调整j的大小
            //kmp核心
            while (j>0 && haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)){
                j++;
            }
            if(j==needle.length()){  //找到了
                return i-(j-1);
            }
        }
        return -1;
    }
    public static int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next=new int[dest.length()];
        next[0]=0; //如果字符串dest的长度为1，部分匹配值就是0

        for (int i = 1,j=0; i <dest.length() ; i++) {  //i就是字符串的部分指针，  j就是部分匹配值的长度
            //当dest.charAt(i)!=dest.charAt(j) 时，需要从next[j-1]中获取新的j
            //直到发现dest.charAt(i)==dest.charAt(j)时才退出  ,这是kmp的核心点
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];     //回朔,从部分匹配表中更新j
            }
            //当dest.charAt(i)==dest.charAt(j)满足时，部分匹配值就+1,比如AA的情况 next={0,1}
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
