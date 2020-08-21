package 二零年8月;

/**
 * 把字符串转为整数
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 * 思路：  首先当然是 去掉首尾空格
 *      之后的步骤 主要是遍历每一个字符，只要注意以下几点就可：
 *
 *      判断是否为数字
 *      单位
 *      数字的大小是否越界
 */
public class S67 {
    public int strToInt(String str) {
        char[] c=str.trim().toCharArray();
        if(c.length==0){
            return 0;
        }
        int res=0,bndry=Integer.MAX_VALUE / 10; // bndry:拼接数字的边界值
        int i=1,sign=1; //sign: 判断正负的符号位
        if(c[0]=='-'){
            sign=-1;
        }else if(c[0]!='+'){
            i=0;
        }
        for (int j=i;j<c.length;j++){
            if(c[j]<'0' || c[j]>'9'){
                break;
            }
            //判断 res 在此轮拼接后是否超过 21474836472147483647 ，注意这个临界值个位为 7
            if(res>bndry || res==bndry && c[j]>'7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res=res*10+(c[j]-'0');
        }
        return sign*res;
    }
}
