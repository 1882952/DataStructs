package 二0年4月;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 
str 中的每个非空单词之间存在着双向连接的对应规律。
示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false

思路：就是创建一个hash表将patter作为key，对应str作为值保存，如果当前key不存在，则false(因为pattern是对称的)
* */
public class LeetCode290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map=new HashMap<>();
        String []strs=str.split(" ");
        if(pattern.length()!=strs.length){
            return false;
        }
        for (int i = 0; i <pattern.length() ; i++) {
            char key=pattern.charAt(i);
            if(map.containsKey(key)){
                if(!map.get(key).equals(strs[i])){
                    return false;
                }
            }else {
                //判断 value 中是否存在,不加这个会遇到
                /*
                * pattern = "abba"
                  str = "dog dog dog dog"   这个会报错
                * */
                if(map.containsValue(strs[i])){
                    return false;
                }
                map.put(key,strs[i]);
            }
        }
        return true;
    }
}
