package 二零年2月;
/*
* 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
* （比如，waterbottle是erbottlewat旋转后的字符串）。

示例1:
 输入：s1 = "waterbottle", s2 = "erbottlewat"
 输出：True
示例2:
 输入：s1 = "aa", "aba"
 输出：False
* */
public class InterView09 {
    //自己写的，在判断较长字符串时报错
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length())
            return false;
        if (s1.equals(s2))
            return true;

        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <s1.length() ; i++) {
            if(s1.charAt(i)==s2.charAt(0)){
                break;
            }
            builder.append(s1.charAt(i));
        }
        int bl=builder.length();
        String ss2=s2.substring(s2.length()-bl,s2.length());
        if(ss2.equals(builder.toString())){
            return true;
        }
        return false;
    }

    public boolean isFlipedString1(String s1, String s2) {
        if (s1.length()!=s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i)==s2.charAt(0)){
                StringBuilder sb=new StringBuilder();
                sb.append(s1.substring(i)).append(s1.substring(0,i));
                if (sb.toString().equals(s2))
                    return true;
            }
        }
        return false;
    }
    //推荐方法，复制连接一遍s1，然后判断里面是否包含s2
    public boolean isFlipedString3(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        s1 += s1;
        return s1.contains(s2);
    }
}
