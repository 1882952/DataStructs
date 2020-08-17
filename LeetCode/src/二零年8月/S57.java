package 二零年8月;

/**
 * 和为S的两个数字
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 思路 ： （1）利用二分查找法，找出target-nums[i] 的数 ，并返回
 *        （2） 使用hashmap
 *        （3）双指针法，效率最高，采用
 */
public class S57 {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while (i<j){
            int sum=nums[i]+nums[j];
            if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }else {
                return new int[]{nums[i],nums[j]};
            }
        }
        return new int[0];
    }
}
