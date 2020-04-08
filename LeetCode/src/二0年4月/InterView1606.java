package 二0年4月;

import java.util.Arrays;

/*
* 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），
* 并返回该对数值的差
示例：
输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
输出： 3，即数值对(11, 8)

思路：就和两字符串数组比较大小一样，先排序，然后利用双指针
* */
public class InterView1606 {

    //这样做是接近的，但是如果是Integer.MAX_VALUE的情况就会报错
    public int smallestDifference(int[] a, int[] b) {
        //先排序
        Arrays.sort(a);
        Arrays.sort(b);

        int res=Integer.MAX_VALUE;
        //然后基于双指针
        int i=0,j=0;
        while (i<a.length&&j<b.length){

           res=Math.min(res,Math.abs(a[i]-b[j]));
           if(a[i]<b[j]){  //a[i]相对较小，那么就让i++
               i++;
           }else {  //反之就是j++
               j++;
           }
        }
        return res;
    }

    //加上遇到Integer.MAX_VALUE就跳过的情况
    public int smallestDifference1(int[] a, int[] b){
        //先排序
        Arrays.sort(a);
        Arrays.sort(b);

        long res=Integer.MAX_VALUE;  //使用long，使用int型报错，原因是溢出（Integer.MaxVaue）
        //然后基于双指针
        int i=0,j=0;
        while (i<a.length&&j<b.length){
            if(a[i]==b[j]){
                return 0;   //有相同的值就返回0；
            }
            if(a[i]==Integer.MAX_VALUE){
                i++;
                continue;
            }
            if(a[i]<b[j]){
                res=Math.min(res,(long)Math.abs(a[i]-b[j]));
                i++;
            }else {
                res=Math.min(res,(long)Math.abs(a[i]-b[j]));
                j++;
            }
        }
        return (int)res;
    }
}
