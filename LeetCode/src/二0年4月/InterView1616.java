package 二0年4月;
/*
* 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，
* 整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。
* 函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。

示例：

输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
输出： [3,9]

思路,利用双指针，一个从数组头部向右，一个从数组尾部向左，
左指针比较只能是从小到大向右比较，右指针只能是从大到小向左比较。
原理：如果左侧最大值大于中间的最小值，则一定会被中间序列包括；
      同理，如果右侧最小值小于中间的最大值，则一定会被中间序列包括。

     那么，目的就变成了找出中间的最小值与最大值。

1、从前向后扫描数组，判断当前array[i]是否比max小，是则将last置为当前array下标i，否则更新max;
2、从后向前扫描数组，判断当前array[len - 1 - i]是否比min大，是则将first置位当前下标len - 1 - i，
否则更新min;
3、返回{first， last}
* */
public class InterView1616 {
    public int[] subSort(int[] array) {
        if(array==null || array.length==0){
            return new int[]{-1,-1};
        }
        int last=-1,first=-1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int len=array.length;
        //注意，需要对称地去看，中间不有序的规则：左边是最大值大于右侧的最小值，右边是最小值小于了左侧的最大值
        for (int i = 0; i <array.length ; i++) {
            if(array[i]<max){ //右侧的最小值小于了中间的最大值
                last=i;
            }else {
                max=Math.max(array[i],max); //如果从左到右依次增大，证明左部分有序，则每次更新最大值max
            }
            if(array[len-1-i]>min){ //左侧的最大值大于了右侧的最小值
                first=len-1-i;
            }else {
                min=Math.min(min,array[len-1-i]);  //如果从右到左依次减小，证明右部分有序，更新min
            }
        }
        int [] arr={first,last};
        return arr;
    }
}
