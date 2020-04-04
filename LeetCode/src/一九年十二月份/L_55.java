package 一九年十二月份;
/*
* 给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
示例 2:
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

思路：贪心法 每次选取上一跳中可达范围 i+a[i]最大的，迭代可达范围，当可达范围到达终点时直接返回true

        * i:代表当前数组中的位数：
        * a[i]：代表当前位数上值（即最大跳跃数）
        * nums.length-1:到达目标
* */
public class L_55 {
    public boolean canJump(int[] nums) {
        int maxPos=0;
        for (int i = 0; i <nums.length; i++) {
            if(i>maxPos){
                return false;
            }
            if(i+nums[i]>maxPos){
                maxPos=i+nums[i];
            }
        }
        return maxPos>=nums.length-1;
    }
}
