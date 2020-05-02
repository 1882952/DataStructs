package 二零年五月;
/*
* 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
* 这条路径可能穿过也可能不穿过根结点。
* 思路，左右子树高度之和就是直径长度,
* 使用一个全局变量保存实时的直径长度。
* */
public class Leetcode543 {
    private int result;
    public int diameterOfBinaryTree(TreeNode root) {
      result=0;
      height(root);
      return result;
    }
    private int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftH=height(node.left);
        int rightH=height(node.right);
        result=Math.max(result,leftH+rightH);
        return Math.max(leftH,rightH)+1;
    }
    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
