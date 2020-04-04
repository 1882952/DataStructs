/*
* 编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"
示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

标签：链表
当字符串数组长度为 0 时则公共前缀为空，直接返回
令最长公共前缀 ans 的值为第一个字符串，进行初始化
遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀
如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
时间复杂度：O(s)，s 为所有字符串的长度之和

总结：用一个数组的子串与其他子串比较
* */
public class L_14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String ans=strs[0];
        for (int i = 1; i <strs.length ; i++) {
            int j=0;                  //在j每次比较后都必须置为0，所以拿出来
            for (;j<ans.length() && j<strs[i].length();j++){
                if(ans.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
            }
           ans=ans.substring(0,j);
            if(ans.equals("")){  //发现其中一个子串无公共的，就返回
                return ans;
            }
        }
        return ans;
    }
}
