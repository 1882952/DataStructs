package 一九年十二月份;
/** 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
如果不存在最后一个单词，请返回 0 。
说明：一个单词是指由字母组成，但不包含任何空格的字符串。
示例:
输入: "Hello World"
输出: 5
* */
public class L_58 {
    public int lengthOfLastWord(String s) {
        //去空格
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        int lastEmptyIndex=s.lastIndexOf(' ');
        return s.length()-1-lastEmptyIndex;
    }
}
