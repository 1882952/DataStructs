import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
* */
public class l_03 {
    /*
    首先：判断有无重复元素，可以优先考虑set集合
    * 思路；使用滑动窗口，如果从索引 i 到 j−1 之间的子字符串 s_{ij}
​	已经被检查为没有重复字符。我们只需要检查 s[j] 对应的字符是否已经存在于子字符串 s_{ij}中。
    通过使用 HashSet 作为滑动窗口，来完成对字符是否在当前的子字符串中的检查。
    注意：滑动窗口是数组或者字符串的常用抽象概念，窗口即[i,j)元素的集合，左闭右开，
        将[i,j)向右滑动一个元素，则将它变为[i+1,j)

   使用hashset HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初j=i）中。
      然后我们向右侧滑动索引 j，如果它不在 HashSet 中，我们会继续滑动 j。
      直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。
      如果我们对所有的 ii 这样做，就可以得到答案。

      总结：滑动窗口即没有重复元素，可以不断扩张的集合,如果遇到重复元素，则i后移一位，重新开始扩展
    * */
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Set<Character> set=new HashSet();
        int ans=0,i=0,j=0; //ans：最长子串的实时长度
        while (i<n && j<n){
            if(!set.contains(s.charAt(j))){ //判断集合中不存在该元素
                set.add(s.charAt(j++));
                ans=Math.max(ans,j-i);
            }
            else{
                set.remove(s.charAt(i++));  //若存在重复元素，则i后移一位
            }
        }
        return ans;
    }

    //改进，不需要通过集合，直接通过索引来完成,
    public int lengthOfLongestSubstringa(String s) {
        int n = s.length(), maxsize = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {  //若j在map的key中存在，则结算
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxsize = Math.max(maxsize, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return maxsize;
    }
}
