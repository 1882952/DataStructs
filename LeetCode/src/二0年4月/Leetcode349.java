package 二0年4月;

import java.util.HashSet;
import java.util.Set;

/*
* 给定两个数组，编写一个函数来计算它们的交集。
示例 1:
输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:
输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
思路：利用二分查找的话，遍历一个数组，二分查找另一个数组，遍历的数组优先选取短的，二分查找的数组必须先排序，
然后把能查找到的元素添加到一个不重复的集合中，最后转化为数组返回， 但是利用二分的时间复杂度并不理想，为O(nlogn)

      或者可以利用双指针，先将两数组排序，然后依次遍历比较， 这与二分类似，必须用到排序

      所以最终简便点，直接用两个set就完事了
* */
public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> pset=new HashSet<>();
        Set<Integer> cset=new HashSet<>();
        int length=nums1.length;
        int[] temp1=nums1;
        int[] temp2=nums2;
        if(length>nums2.length){
            length=nums2.length;
            temp1=nums2;
            temp2=nums1;
        }
        for (int i = 0; i <length ; i++) {
            pset.add(temp1[i]);
        }
        for (int i = 0; i <temp2.length ; i++) {
            if(pset.contains(temp2[i])){
                cset.add(temp2[i]);
            }
        }
        int[] res=new int[cset.size()];
        int index=0;
        for (Integer i:cset){
            res[index++]=i;
        }
        return res;
    }
}
