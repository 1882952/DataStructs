package 二0年七月;

import java.util.HashSet;
import java.util.Set;

/*
* 找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
* 请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
* */
public class S003 {
    //使用两指针遍历， 时间复杂度为O(n)  （内部for根据时间复杂度分析，为n+n-1+n-2+。。。。+1 ，所以综合来说是n）
    public int findRepeatNumber(int[] nums) {
        int len=nums.length;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++){
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    //使用set集合添加，时间复杂度为O(n)
    public int findRepeat(int []nums){
        int repate=-1;
        Set<Integer> set=new HashSet<>();
        for(int i : nums){
            if(!set.add(i)){
                repate=i;
                break;
            }
        }
        return repate;
    }
}
