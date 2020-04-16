package 二0年4月;

import java.util.Arrays;
import java.util.List;

/*
* 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
示例 1：
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。

思路：那么就可以将该问题这样变一下，先求出nums的和sum，然后求出m=sum/k,
那么这个问题就是f(n)=f(n-1)+m, k只是栈深度的判断 ，f（n）是当前数组中元素的和
当栈深度不足或者栈深度超过时都返回false
但是对于这个f（n-1），因为是数组，所以要通过构造子集数组的方式来解这个问题，k就是子集的大小
* */
public class LeetCode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum= Arrays.stream(nums).sum();
        if(sum%k>0){
            return false;
        }
        int target=sum/k;
        Arrays.sort(nums);
        int row=nums.length-1;
        if(nums[row]>target){
            return false;
        }
        while (row>=0 && nums[row]==target){
            k--;
            row--;
        }
        return search(new int[k],row,nums,target);
    }

    /**
     *
     * @param groups:子集 ,子集的个数是k
     * @param row   ：有效数组中的最后一位的下标
     * @param nums  :原数组
     * @param target :平均值m
     * @return
     */
    public boolean search(int[] groups,int row,int []nums,int target){
        if(row<0){
            return true;
        }
        int v=nums[row--]; //获取当前数组中的最后一个元素，然后通过遍历数组子集找到是否有target
        for (int i = 0; i <groups.length ; i++) { //现在就是遍历子集，找出是否含有target
            if(groups[i]+v<=target){
                groups[i]+=v;
                if(search(groups,row,nums,target)){return true;}
                groups[i]-=v;
            }
            if(groups[i]==0){  //可减少递归的重复性工作
                break;
            }
        }
        return false;
    }
}
