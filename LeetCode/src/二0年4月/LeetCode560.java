package 二0年4月;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
示例 1 :
输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

思路：使用map，保存符合的情况。
这种思想需要使用累计总和，如果累计总和 在索引i与索引j处相差k，即sum[i]-sum[j]=k,
则位于索引 i和 j之间的子数组之和就是k。
那么map中的key就是sum和
* */
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int count=0,sum=0;
        //Key:是前缀和sum，Value是对应的子数组数目
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i = 0; i <nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k)){ //说明当前位置有子数组， sum[i]-sum[j]=k,那么sum[j]-k=sum[i]
                count+=map.get(sum-k);
            }
            //否则就把当前位置的和添加进去
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
