package 二零年3月;

import java.util.Arrays;

/*
* 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索
* 树。
示例:
给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
          0
         / \
       -3   9
       /   /
     -10  5
    思路应该是先对数组进行排序，再每次按照中位数作为root生成树,注意是！每次都是利用中位数生成树的节点
总结来说,就是利用了二分法与递归生成树,每次利用中位数这样生成的二叉搜索树才是平均的。
* */
public class InterView0402 {
    public TreeNode sortedArrayToBST(int[] nums) {
      if(nums.length==0){
          return null;
      }
      TreeNode node=new TreeNode(nums[nums.length/2]);
      node.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,nums.length/2));
      node.right= sortedArrayToBST(Arrays.copyOfRange(nums,nums.length/2+1,nums.length));
      return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
  }
