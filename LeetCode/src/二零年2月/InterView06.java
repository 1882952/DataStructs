package 二零年2月;

import java.util.HashMap;
import java.util.Map;

/*
* 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，
* 字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
* 你可以假设字符串中只包含大小写英文字母（a至z）。

示例1:
 输入："aabcccccaaa"
 输出："a2b1c5a3"
示例2:
 输入："abbccd"
 输出："abbccd"
 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
* */
public class InterView06 {
    public String compressString(String S) {
        if(S.isEmpty()){
            return S;
        }
        if(S.length()==2&& (S.charAt(0)==S.charAt(1))){
            return S;
        }
        //利用单指针遍历
        StringBuilder builder=new StringBuilder();
        builder.append(S.charAt(0));
        int count=1;  //字符出现次数，连续出现一次加1,如果当前位与上一位不同了，则重置为1
        for (int i = 1; i <S.length() ; i++) {
            if(builder.charAt(builder.length()-1)==S.charAt(i)){
                ++count;
            }else {
                builder.append(count);
                count=1;  //重置为1
                builder.append(S.charAt(i));
            }
        }
        builder.append(count);  //最后一个出现的次数
        return builder.length()>S.length()?S:builder.toString();
    }

    public static void main(String[] args) {
        InterView06 nn=new InterView06();
        String s=nn.compressString("aabbdddccc");
        System.out.println(s);
    }
}

