package 二零年8月;

/**
 * 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。

    思路 ： （1） 以空格为分割线转为String数组，然后数组逆序输出。 s.trim().split(" "); // 删除首尾空格，分割字符串
           （2） 利用双指针确定每个单词的边界，然后倒序输出,从最后一个单词开始
 */
public class S58_1 {
    //利用双指针
    public String reverseWords(String s) {
        s=s.trim(); //去空格
        int j=s.length()-1, i=j;
        StringBuilder res=new StringBuilder();
        while (i>=0){
            while (i>=0 && s.charAt(i)!=' '){ //从后向前找到首个空格
                i--;
            }
            res.append(s.substring(i+1,j+1)+" ");
            while (i>=0 && s.charAt(i)==' '){ //跳过单词间的空格
                i--;
            }
            j=i; //指向前一个单词末尾
        }
        return res.toString().trim();
    }
}
