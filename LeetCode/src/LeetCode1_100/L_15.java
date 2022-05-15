package LeetCode1_100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组问题：
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
  思路：经典问题, 可以先外层循环一次，然后变成双指针法；
 */
public class L_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length <2 ){
            return new ArrayList<>();
        }

        //先排个序
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = null;

        for (int k = 0; k <nums.length-2; k++) {
            // 如果 k 位的值大于0，那么就跳过，因为，i，j的位置都比它大
            if(nums[k]>0){
                break;
            }
            //同时移除相邻元素相同的情况
            if( k>0 && nums[k]==nums[k-1]){
                continue;
            }
            int i=k+1,j=nums.length-1;
            while (i<j){
                if(nums[i]+nums[j] == nums[k]){
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }else if(nums[i]+nums[j]>nums[k]){
                    while (i < j && nums[j] == nums[--j]);
                }else {
                    while (i < j && nums[i] == nums[++i]);
                }
            }
        }

        return result;
    }
}
