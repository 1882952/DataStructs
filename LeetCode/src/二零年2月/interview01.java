package 二零年2月;
//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
/*
* 示例 1：

输入: s = "leetcode"
输出: false
示例 2：

输入: s = "abc"
输出: true
* */
public class interview01 {
    public boolean isUnique(String astr) {
        if(astr==null){
            return false;
        }else if(astr.length()==1){
            return true;
        }else {
            //双指针
            for (int i = 0; i <astr.length()-1 ; i++) {
                for (int j = i+1; j <astr.length(); j++) {
                    if(astr.charAt(i)==astr.charAt(j)){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
