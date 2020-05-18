package 二零年五月;

import java.util.HashMap;
import java.util.Map;

/*  第一次只出现一个字符
    在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
示例:
s = "abaccdeff"
返回 "b"
s = ""
返回 " "

思路：使用hash，添加字符，value是判断该字符是否存在
     或者使用数组代替hash计数，但是这种做法需要定义数组大小为256，即需要用ASCII码作为下标，数组值为出现的次数
* */
public class View50 {
    //使用hash表，较为简单易思考
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map=new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c,!map.containsKey(c)); //true表示只有一个
        }
        for (char c: s.toCharArray()) {
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }
    //使用数组代替hash表
    public char firstUniqChar1(String s) {
        int[] count=new int[256];
        for (char c:s.toCharArray()){
            count[c]++;
        }
        for (char c:s.toCharArray()){
            if(count[c]==1){
                return c;
            }
        }
        return ' ';
    }
}
