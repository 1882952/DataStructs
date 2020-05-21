package 二零年五月;

/*  多数元素
*   给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 
示例 1:
输入: [3,2,3]
输出: 3
示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2
*
* 思想：这道题最简单的方式就是采用hashmap存储， 这里采用分治算法
*
* 如果数 a 是数组 nums 的众数，如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数。
* 所以先分开，直到单个数字区间，那么都是众数，然后合并区间，判断两区间出现次数最多的数，即该区间的众数。
* */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        return  majorityElementRec(nums,0,nums.length-1);
    }
    //求一个区间中某个数字的次数
    private int countInRange(int[] nums,int num,int lo,int hi){
        int count=0;
        for (int i = lo; i <=hi ; i++) {
            if(nums[i]==num){
                count++;
            }
        }
        return count;
    }
    //分治的核心 ,返回值为当前分区的众数
    private int majorityElementRec(int[] nums, int lo, int hi) {
        if(lo==hi){
            return nums[lo];
        }
        //分
        int mid=(hi-lo)/2+lo;
        int left=majorityElementRec(nums,lo,mid);
        int right=majorityElementRec(nums,mid+1,hi);

        //和（回溯），因为只统计，所以不用去排序
        if(left==right){ //两分区的众数个数相等，那么久返回左边的
            return left;
        }
        //求两分区的众数次数
        int leftCount= countInRange(nums,left,lo,hi);
        int rightCount=countInRange(nums,right,lo,hi);

        return leftCount>rightCount ? left : right;
    }
}
