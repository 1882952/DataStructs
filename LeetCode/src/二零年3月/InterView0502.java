package 二零年3月;
/*
* 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），
* 类型为double，打印它的二进制表达式。
* 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。

示例1:

 输入：0.625
 输出："0.101"
示例2:
 输入：0.1
 输出："ERROR"
 提示：0.1无法被二进制准确表示
提示：
32位包括输出中的"0."这两位。

考点：逻辑电路的小数部分
二进制小数部分计算：0+2^(-1)+2^(-2)+2^(-3)+....

解决过程是不停的乘2取整数部分，有可能得到的新的数永远不等于 0

在java中对于32位以内最多计算33次，若中间得到0就返回，若是计算了33次，就返回error
* */
public class InterView0502 {
    public String printBin(double num) {
        StringBuilder sb=new StringBuilder();
        sb.append("0.");
        for (int i = 0; i <33 ; i++) {
            if(num==0){
                return sb.toString();
            }
            //不停的乘2取整
            num*=2;
            if(num>=1){     //如果整数>1，就取1
                sb.append("1");
                num-=1;
            }else {         //如果整数小于1，就取0
                sb.append("0");
            }
        }
        return "ERROR";
    }
}
