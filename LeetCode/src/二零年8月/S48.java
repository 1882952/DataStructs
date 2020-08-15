package 二零年8月;

import java.util.HashMap;
import java.util.Map;

/** 最长不含重复字符的子串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * 思路 ： 应该从字符串匹配问题考虑，可以利用tcp传输时的滑动窗口思想解决问题。
 *    具体实现方法如下： （1）动态规划+哈希表
 *                    （2）动态规划+线性遍历
 *                    （3）双指针+哈希表
 *
 */
public class S48 {
    //使用双指针+哈希表解决问题
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>(); //保存字符与其出现的位置
        int i=-1,res=0;
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){ //如果当前j位置上的字符在map中出现，就更新i
                i=Math.max(i,map.get(s.charAt(j))); //更新左指针
            }
            //在map添加当前字符，更新子串长度
            map.put(s.charAt(j),j);//哈希表记录
            res=Math.max(res,j-i);
        }
        return res;
    }
}
