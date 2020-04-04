/*
* 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。

思路：符合直觉的做法是，减数一次一次减去被减数，不断更新差，直到差小于0，我们减了多少次，结果就是多少。
    但其实本质是有序数组查找指定的值（比如：10/3  ，1（减一次3），2（减两次三），3（减三次3），4（减四次3为负，退出），
    1 2 3 4 有序序列）
    在正负数的判断中，：boolean sign = (dividend > 0) ^ (divisor > 0);  用左移去减
    由于正数边界问题比较麻烦，所以改用负数计算。
* */
public class L_29 {
    public int divide(int dividend, int divisor) {
        boolean sign=(dividend>0)^(divisor>0);
        int result=0;
        if(dividend>0){
            dividend=-dividend;
        }
        if(divisor>0){
            divisor=-divisor;
        }
        while (dividend<=divisor){
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }
}
