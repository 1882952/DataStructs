package 二0年七月;
/*
* 替换空格
* 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
* */
public class S005 {
    public String replaceSpace(String s) {
        StringBuilder sb=new StringBuilder();
        for (char c : s.toCharArray()){
            if(c==32){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
