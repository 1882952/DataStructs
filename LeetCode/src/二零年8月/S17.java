package 二零年8月;


import java.util.ArrayList;
import java.util.List;

/*打印从1到最大的n位数
* 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
*
* 思路：用10的阶乘解决问题,但是这并不是考察这道题的本意，而且不能解决大数问题
*       这道题考察的是字符串的使用，比较麻烦，但是可以解决大数问题，面试需用。
* */
public class S17 {
    public int[] printNumbers(int n) {
        List<String> list=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        for (int i = 0; i <n ; i++) { //将str初始化为n个0组成的字符串
            str.append('0');
        }
        while (!increment(str)){
            //去掉左侧的0
            int index=0;
            while (index<str.length() && str.charAt(index)=='0'){
                index++;
            }
            String s=str.toString().substring(index);
            list.add(s);

        }
        int[] res=list.stream().mapToInt(Integer::valueOf).toArray(); //活用stream流
        return res;
    }


    //利用进位判断,若发生进位则一直进行for循环，直到不产生进位则break。如果i为0（即到了最高位）还发生了进位，则设置isOverflow为true，
    // 并返回至主函数的while判断。
    public boolean increment(StringBuilder str){
        boolean isoverflow=false;
        for (int i = str.length()-1; i >=0 ; i--) {
            char s=(char) (str.charAt(i)+1);
            //如果s>9则发生进位
            if(s>'9'){
                str.replace(i,i+1,"0");
            }
            if(i==0){
                isoverflow=true; //到了最高位
            }else { //没发生进位就跳出循环
                str.replace(i,i=1,String.valueOf(s));
                break;
            }
        }

        return isoverflow;
    }
}
