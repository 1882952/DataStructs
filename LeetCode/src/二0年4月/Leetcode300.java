package 二0年4月;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

思路：采用二分查找为基本思路，
使用贪心+二分查找
用一个集合保存最长的上升子序列，
如果遇到的元素比集合中的最后一个元素小，那么就替换，否则，就添加到集合中，在集合中查找对应的位置时使用二分查找
* */
public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        List<Integer> arrays=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            //如果集合为空，或者集合中的最后一个元素小于当前元素，那么就将当前元素添加
            if(arrays.size()==0 || arrays.get(arrays.size()-1)<nums[i]){
                arrays.add(nums[i]);
                continue;
            }
            //如果nums[i]比Array的最大值小，那么就需要在Array中找到一个合适的位置，将num[i]放入，这就是二分查找的过程
            int begin=0, end=arrays.size()-1,mid=0;
            while (begin<=end){
                mid=begin+(end-begin)/2;
                if(arrays.get(mid)>nums[i]){
                    end=mid-1;
                }else if(arrays.get(mid)<nums[i]){
                    begin=mid+1;
                }else {
                    begin=mid;
                    break;
                }
            }
            arrays.set(begin,nums[i]); //最后替换到begin位置
        }
        return arrays.size();
    }
}
