package 二零年8月;
/*
* 表示数值的字符串
* 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
* 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。

    思路：字符串的首字符除了正负号数字之外，其他的字符都无效， 首字符之后除了纯数字外，还有小数点，指数e有效，其余均无效
*   解决方式：（1）可以使用有限状态机解决问题，先根据题意得出不同状态画出状态转移图，然后得出状态转移表后写代码，
*           （2）正常做法，遍历字符串，分情况判断每个字符对应的元素。
*
*   这里采用正常做法。思路就是设置三个情况判断， 每个字符都要判断是否遇到这三种情况， 遇到过数字，遇到过小数点，遇到过e
* */
public class S20 {
    public boolean isNumber(String s) {
        if(s==null || s.length()==0){
            return false;
        }

        //标记是否遇到相应情况
        boolean numseen=false;
        boolean dotseen=false;
        boolean eseen=false;
        char[] str=s.trim().toCharArray(); //去空格后转为数组

        for (int i = 0; i <str.length ; i++) {
            if(str[i]>='0' && str[i]<='9'){
                numseen=true;
            }else if(str[i]=='.'){
                // . 之前不能出现点或者e
                if(dotseen || eseen){
                    return false;
                }
                dotseen=true;
            }else if(str[i]=='e' || str[i]=='E'){
                //e之前不能出现e，并且必须出现数字
                if(eseen || !numseen){
                    return false;
                }
                eseen=true;
                numseen=false; //重置numseen，排除123e或者123e+的情况，确保e之后也出现数字.
            }else if(str[i]=='-' || str[i]=='+'){//+-出现在0位置或者e/E的后面第一个位置才是合法的
                if(i!=0 && str[i-1]!='e' && str[i-1] !='E'){
                    return false;
                }
            }else { //其它不合法情况
                return false;
            }
        }
        return numseen;
    }
}
