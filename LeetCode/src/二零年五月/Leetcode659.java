package 二零年五月;

import java.util.HashMap;
import java.util.Map;

/*
分割数组为连续子数组
* 输入一个按升序排序的整数数组（可能包含重复数字），
* 你需要将它们分割成几个子序列，其中每个子序列至少包含三个连续整数。
* 返回你是否能做出这样的分割？
示例 1：
输入: [1,2,3,3,4,5]
输出: True
解释:
你可以分割出这样两个连续子序列 :
1, 2, 3
3, 4, 5

思路：使用单map加贪心算法
把数组元素按数字保存，然后依次遍历数组，子数组遇到重复的元素就停止，然后判断长度是否小于三
* */
public class Leetcode659 {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i: nums) {
            //子数组的元素个数
            int subNum=0;
            //下一个元素
            int next=i;
            int p=1;
            //这是判断子数组的逻辑，当下一位遇到重复元素时，将下一位元素的value值-1，然后跳出循环
            while (map.getOrDefault(next,0)>=p){
                p=map.get(next);
                map.put(next,p-1);
                ++subNum;
                ++next;
            }
            if(subNum>0 && subNum<3){
                return false;
            }
        }
        return true;
    }
}
