package 二0年4月;
/*
* 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
*
* 思路：使用移位运算
* 判断a-b为正数还是负数,int类型负数首位为1，正数为0
所以右移31位 得到正负数 0或1 然后与a，b相乘得结果
由于溢出问题，int转为long进行右移。    >>>和>>区别 >>>无符号右移
* */
public class InterView1607 {
    public int maximum(int a, int b) {
        long c=a,d=b;
        int res=(int)((c-d)>>>63);
        return b*res+a*(res^1);  //res与a，b相乘得结果
    }
}
