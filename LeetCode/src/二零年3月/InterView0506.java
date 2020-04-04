package 二零年3月;
/*
* 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
示例1:
 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 输出：2
示例2:
 输入：A = 1，B = 2
 输出：2
提示:
A，B范围在[-2147483648, 2147483647]之间

//思路：很简单：两数字的二进制异或之后的出现一的个数  ，因为相同为0，不同为1是异或
* */
public class InterView0506 {
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A^B);
    }
}
