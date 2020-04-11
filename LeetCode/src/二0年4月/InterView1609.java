package 二0年4月;
/*
* 请实现整数数字的乘法、减法和除法运算，运算结果均为整数数字，
* 程序中只允许使用加法运算符和逻辑运算符，允许程序中出现正负常数，不允许使用位运算。
你的实现应该支持如下操作：
Operations() 构造函数
minus(a, b) 减法，返回a - b
multiply(a, b) 乘法，返回a * b
divide(a, b) 除法，返回a / b
示例：

Operations operations = new Operations();
operations.minus(1, 2); //返回-1
operations.multiply(3, 4); //返回12
operations.divide(5, -2); //返回-2

思路：只能用加法和逻辑运算符，解法如下：
减法： 将b取反，相加
乘法：通过累加完成，先用累加实现一个乘数在10以内的乘法，
如果乘数超过10，就用乘数的每一位和被乘数相乘，也就是使用递归，将得到的积再相加，注意移位（这里只能用乘10来补0）；
例子 ；10*123= 10*3+10*20+10*100=10*3+10*2*10+10*10*10， 这样就可以利用十以内的乘法，递归求解。

除法：与乘法类似；
* */
public class InterView1609 {
    public InterView1609() {

    }

    public int minus(int a, int b) {
        return a+(-b);
    }

    public int multiply(int a, int b) {
        if(b==0){
            return 0;
        }

        boolean negative = (a>0&&b<0) || (a<0&&b>0); //需要考虑结果的正负号
        a = Math.abs(a);
        b = Math.abs(b);
        //如果b<=10,就累加实现一个乘数在10以内的乘法
        int ans=0;
        if(b<=10){
            for (int i = 0; i <b ; i++) {
                ans+=a;   //使用累加
            }
            return negative ? -ans:ans; //然后返回
        }
        String sb=String.valueOf(b);
        for (int i = sb.length()-1; i>=0 ; i--) {
            int bit=sb.charAt(i)-'0';  //保存b中的每个位数上的数字
            int multi=multiply(a,bit);  //递归，得到每个位数上数字的结果
            for (int j = 0; j <sb.length()-1-i ; j++) {
                multi=multiply(multi,10);
            }
            ans+=multi;  //将每一位的结果相加
        }
        return negative ? -ans:ans;
    }

    public int divide(int a, int b) {
        if(b==1)    return a;
        if(b==-1)   return minus(0, a);
        boolean negative = (a>0&&b<0) || (a<0&&b>0);
        a = Math.abs(a);
        b = Math.abs(b);
        if(a < b)   return 0;

        int ans = 0;
        int cur = 0;
        String sa = String.valueOf(a);
        for(int i=0; i<sa.length(); i++){
            int c = sa.charAt(i)-'0';
            cur = multiply(cur, 10) + c;
            int count = 0;
            while(cur >= b){
                cur = minus(cur, b);
                count++;
            }
            ans = multiply(ans, 10) + count;
        }
        return negative ? -ans : ans;
    }
}
