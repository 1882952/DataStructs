package 二零年8月;
/*
    数值的整数次方

* 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

    思路：可以通过二进制关系解决问题，
        也可以二分法角度解决问题，这里使用二分法
        二分推导： x^n=x^n/2 * x^n/2=........, 当然要n分奇偶情况 ，n/2为向下整除
        当n为偶数时：x^n=(x^2)^n/2
        当n为奇数时：x^n=x * (x^2)^n/2 ，即多出一项x

        根据二分推导，可通过循环 x = x^2操作，每次把幂从 n 降至 n/2 ，直至将幂降为 0 ；
* */
public class S16 {
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        long b=n;
        double res=1.0;
        if(b<0){ //负指数幂
            x=1/x;
            b=-b;
        }

        while (b>0){ //直到幂降为0为止
            if((b&1)==1){ //如果幂指数n为奇数
                res*=x;
            }
            x*=x;  //x平方
            b>>=1; //幂指数右移1位
        }
        return res;
    }
}
