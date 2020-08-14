package 二零年8月;
/*
* 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。


*   思路：将 1~n 的个位，十位，百位，。。。， 出现1的次数相加，得到1的总和。
*
* 具体步骤参考LeetCode题解 ,分为高位high，当前位cur，低位low
*           根据cur的值分情况得出出现1的次数
*
* */
public class S43 {
    public int countDigitOne(int n) {
        int digit=1,res=0; // digit 代表位因子，10^i
        int high=n/10,cur=n%10,low=0; // high: cur的高位  cur：当前位  low：cur的低位  ,默认cur为十位上的数字

        while (cur!=0 || high!=0){
            //按照cur的值，得出当前位上出现1的数字的次数
            if(cur==0){
                res+=high*digit;
            }else if(cur==1){
                res+=high*digit+low+1;
            }else {
                res+=(high+1)*digit;
            }
            //调整为下一轮
            low+=cur*digit;
            cur=high%10;
            high/=10;
            digit*=10;
        }
        return res;
    }
}
