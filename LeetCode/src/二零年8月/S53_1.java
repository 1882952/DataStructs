package 二零年8月;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路 ： （1）直接暴力搜索，找到target后向后循环查找，直到查到所有的次数。
 *        （2）二分查找， 找到该数区域的右边界， 减去前一个数达到右边界，即次数
 *                      或者先二分找出右边界，然后找出左边界，左右边界相减即可。
 */
public class S53_1 {
    public int search(int[] nums, int target) {
        return helper(nums,target)-helper(nums,target-1);
    }

    /**
     * 返回的是tar的右边界位置
     * @param nums
     * @param tar
     * @return
     */
    private int helper(int[] nums,int tar){
        int i=0,j=nums.length-1;
        while (i<=j){
            int m=i+(j-i)/2;
            if(nums[m]<=tar){ //在右半边
                i=m+1;
            }else {  //在左半边
                j=m-1;
            }
        }
        return i;
    }
}
