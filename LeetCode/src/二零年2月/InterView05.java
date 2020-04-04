package 二零年2月;
/*
* 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，
* 编写一个函数判定它们是否只需要一次(或者零次)编辑。
示例 1:
输入:
first = "pale"
second = "ple"
输出: True
 
示例 2:
输入:
first = "pales"
second = "pal"
输出: False
* */
public class InterView05 {
    public boolean oneEditAway(String first, String second) {
     //利用双指针解决问题,从问题可以看出，两字符串只有一处不同，超过一处就返回错误
        if((Math.abs(first.length()-second.length())>1)){
            return false;
        }
        int i=0,j=0;
        int c=0;  //修改的次数
        while (i<first.length() && j<second.length()){
            if(first.charAt(i)==second.charAt(j)){
                i++;
                j++;
            }else if(i+1<first.length() && first.charAt(i+1)==second.charAt(j)){
                c++;
                i++;
            }else if(j+1<second.length() && first.charAt(i)==second.charAt(j+1)){
                c++;
                j++;
            }else {
                c++;
                j++;
                i++;
            }
        }
        //第一个字符串剩余和第二个字符串剩余以及修改次数之和不能超过1次
        return c+Math.abs(i-first.length())+Math.abs(j-second.length())<2;
    }
}
