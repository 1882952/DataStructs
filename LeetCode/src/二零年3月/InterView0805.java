package 二零年3月;
/*
* 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、
* 减号、位移，但要吝啬一些。
示例1:
 输入：A = 1, B = 10
 输出：10
示例2:
 输入：A = 3, B = 4
 输出：12

 递归的解答看不懂，就用移位来解决问题。

  解答思路：
    1：首先求得A和B的最小值与最大值。

    然后，可以对其中的最小值当做乘数（为什么选最小值，因为选最小值当乘数，可以算的少），
    将其拆分成2的倍数的和，即min = a0 * 2^0 + a1 * 2^1 + ... + ai + 2^i + ... ，其中ai取0或者1。
    其实就是用二进制的视角去看到min，比如12用二进制标识就是1100，即1000+0100。
    举个例子，13 * 12 = 13 * (8 + 4) = 13 * 8 + 13 * 4 = (13 << 3) + (13 << 2);

    所以核心是什么，可将一个较小的数拆分为2的倍数， 这样就可以用大的数左移来解决问题

    还有一点要注意min & 1，按位与1，这样结果如果等于1，则证明这个数不能再被分割为2的倍数。
* */
public class InterView0805 {
    public int multiply(int a, int b) {
        //找到两数中的最小值与最大值
        int min= a<b?a:b;
        int max= a>b?a:b;
        if(min==0){
            return 0;
        }
        int ans=0;  //乘积
        for (int i=0;min!=0;i++){  //min每右移一次i+1
            if((min & 1)==1){  //证明min<2,右移不了了，将max左移相应位数
                ans+= max<<i;
            }
            min>>=1;  //继续右移
        }
        return ans;
    }
}
