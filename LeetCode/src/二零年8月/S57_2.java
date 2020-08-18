package 二零年8月;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为S的连续正整数
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 思路 : (1) 依次遍历，保存符合条件的值
 *      （2） 使用滑动窗口解决问题， 一个容器+双指针 , 滑动窗口规则 ： 左闭右开区间
 *           规则： 和小于target，右指针右移一位；
 *                 和大于target，左指针右移一位；
 *                 和等于target，保存i<--->j的区域，然后i左边界右移一位
 */
public class S57_2 {
    public int[][] findContinuousSequence(int target) {
        int i=1,j=1; //滑动窗口的左右边界
        int sum=0; //滑动窗口中数字的和

        List<int[]> res=new ArrayList<>();
        while (i<=target/2){ //如果左边界不小于target的一半，那么左右边界之和肯定大于target
            if(sum<target){
                sum+=j; //右边界向左移动
                j++;
            }else if(sum>target){
                sum-=i; //左边界向右移动
                i++;
            }else { //符合target的情况
                int [] arr=new int[j-i];
                for (int k = i; k <j ; k++) {
                    arr[k-i]=k;
                }
                res.add(arr);
                sum-=i;
                i++; //左边界右移
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
