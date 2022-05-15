package LeetCode1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 最简单的思路，递归， f(n) = f(n-1)+print(n)， 然后整个数组都循环一遍,深度优先的思想，关键点在于，需要每一次循环，需要确定当前元素是否被使用过，
 * 这点很重要，要通过这个标记去减支；
 *
 * 思路，此思路是递归循环遍历，但是会有一个visit，证明已经使用过，已经使用过就不能添加，跳过本次循环，然后递归，完成全排列。
 *
 */

public class L_46 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        ArrayList<Integer> temp = new ArrayList<>();
        recure(res,nums,temp,visited);
        return res;
    }

    /**
     *
     * @param res 结果
     * @param nums 输入数组
     * @param temp 中间变量
     * @param visited 判断数组，用这个判断剪支
     * @return
     */
    private void recure(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int[] visited){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if(visited[i]==1){ // 剪枝，当前选中的需要跳过
                continue;
            }
            visited[i]=1;
            temp.add(nums[i]);
            recure(res,nums,temp,visited);
            //递归后返回置为空,供下一次迭代
            visited[i]=0;
            temp.remove(temp.size()-1);
        }
    }
}
