import java.util.Arrays;

/*
* 给定一个包括n 个整数的数组 nums 和 一个目标值 target。找出nums中的三个整数，
* 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

思路：排序与双指针
首先要排序该数组
利用sum=n[i]+n[start]+n[end] ,start,end为数组的双指针,利用双指针的移动来比较
因为nums[i]是从左到右，所以每轮循环比较范围逐渐减小
* */
public class L_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];
        for (int i = 0; i <nums.length; i++) {
            int start=i+1,end=nums.length-1;
            while (start<end){
                int sum=nums[i]+nums[start]+nums[end];
                if(Math.abs(target-sum)<Math.abs(target-ans)){
                    ans=sum;
                }
                if(sum>target){
                    end--;
                }else if(sum<target){
                    start++;
                }else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
