package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 *  在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 *  思路：使用Map保存实现
 */
public class S050 {
    public char firstUniqChar(String s) {
        // 用value对于的boolean值判断是否重复
        Map<Character, Boolean> map =new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            map.put(s.charAt(i),!map.containsKey(s.charAt(i)));
        }
        for (char c: s.toCharArray()) {
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }
}
