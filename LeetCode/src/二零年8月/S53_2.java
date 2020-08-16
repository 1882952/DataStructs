package 二零年8月;

/**
 * 0--n-1 中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 * 思路 ：对于查找，一般来说，除了遍历，还是二分查找,因为是从0---n连续，所以下标也就是对应的值,从这个点入手解决二分。
 */
public class S53_2 {
    public int missingNumber(int[] nums) {
        int i=0,j=nums.length-1;
        while (i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]==mid){ //如果查找的中位数值等于下标，说明前半部分连续，在后半部分查找
                i=mid+1;
            }else {  //后半部分连续
                j=mid-1;
            }
        }
        return i;
    }
}
