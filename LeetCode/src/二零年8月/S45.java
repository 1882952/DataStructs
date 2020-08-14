package 二零年8月;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
    思路：
 此题求拼接起来的 “最小数字” ，本质上是一个排序问题。
 排序判断规则： 设 nums 任意两数字的字符串格式 x 和 y ，则
 若拼接字符串 x + y > y + x ，则 m > n ；
 反之，若 x + y < y + x ，则 n < m ；

  所以做到给数组比较排序就行
 */
public class S45 {
    public String minNumber(int[] nums) {
        String [] str=new String[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            str[i]=String.valueOf(nums[i]);
        }
        //排序
        Arrays.sort(str,(x,y) -> (x+y).compareTo(y+x));
        StringBuilder sb=new StringBuilder();
        for(String s : str){
            sb.append(s);
        }
        return sb.toString();
    }
}
