package LeetCode300_400;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *345. 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 *
 *  思路：还是双指针，遇到前后匹配的，一替换，然后i++，j--， 进行下一位匹配，需要一个额外的空间，去存储元音字母，可以用asc码+。也可以用set把大小写都保存。
 */
public class L_345 {

    public static void main(String[] args) {
        String s = "hello";
        String r = reverseVowels(s);
        System.out.println(r);
    }

    private final static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String s) {
        if(s==null){
            return null;
        }
        int i=0,j=s.length()-1;
        char[] chars = new char[s.length()];
        while (i<=j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!set.contains(ci)){
                chars[i++]=ci;
            }else if(!set.contains(cj)){
                chars[j--]=cj;
            }else {
                chars[i++]=cj;
                chars[j--]=ci;
            }
        }
        return new String(chars);
    }
}
