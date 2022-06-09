package 剑指Offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  思路： 一；遍历数组，然后统计  ， 时间复杂度O(n)
 *        二： 因为是排序数组，所以可以使用二分查找，统计出现数字的次数， 时间复杂度为O(logn)
 *       这道题的二分查找比较精巧， 返回target的右边界， 那么右边界，再去比较target前一个数的大小，相差值就是target的大小
 *       二分法实际来说，在本道题相当于一个偏巧的解法，实际意义并不是很大。
 */
public class S053 {
    public int search(int[] nums, int target) {
        int result =0;
        if(nums.length<1){
            return result;
        }
        return helper(nums,target) - helper(nums,target-1);
    }

    /**
     * 找到小于等于target的右边界
     * @param nums
     * @param target
     * @return
     */
    private int helper(int[] nums, int target){
        int start = 0,end = nums.length-1;
        while (start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid]<=target){  // 找右边界
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return  start;
    }
}
