package 二0年4月;
/*
* 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
* 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
示 1:
输入: [1,3,4,2,2]
输出: 2
示例 2:
输入: [3,1,3,4,2]
输出: 3

这道题考的是抽屉原理，抽屉原理：桌上有十个苹果，要把这十个苹果放到九个抽屉里，无论怎样放，我们会发现至少会有一个抽屉里面
放不少于两个苹果。

方法，使用二分查找，二分法的思路是，先猜一个数（mid），然后统计原始数组中小于等于这个数mid的元素个数cnt，如果cnt严格大于
mid，那么就说明重复的元素在mid的前面。  否则，就在mid的后面。
    而这，就是配合抽屉原理的二分法。
* */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int left=1;
        int right=nums.length-1;
        int mid=0;
        while (left<right){
            mid=(left+right)>>>1;  //无符号右移不会导致溢出
            int cnt=0;
            for (int a:nums){ //查找整个数组，看看有多少个数据小于mid，（因为数据是1---n，所以直接就可用）
                if(a<=mid){
                    cnt++;
                }
            }
            if(cnt>mid){ //说明重复的元素在左区域
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return left;
    }
}
