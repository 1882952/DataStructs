package 二零年8月;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  思路： 递归 f（n）=f（n-1）+n n>1,但是递归的条件判断需要使用到if语句，所以需要利用位运算代替if判断

 */
public class S64 {
    int res=0;
    public int sumNums(int n) {
        boolean x=n > 1 && sumNums(n-1)>0;
        res+=n;
        return res;
    }
}
