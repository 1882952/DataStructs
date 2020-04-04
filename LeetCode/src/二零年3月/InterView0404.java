package 二零年3月;
/*
* 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：
* 任意一个节点，其两棵子树的高度差不超过 1。
示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。
示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
      1
     / \
    2   2
   / \
  3   3
 / \
4   4
返回 false 。

思路：首先想到的还是递归，左子树和右子树高度差大于1就false，递归每层，符合条件每层加1,
求深度
* */
public class InterView0404 {

    private boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        dept(root);
        return flag;
    }

    public int dept(TreeNode node){
        //递归默认返回的递归条件
        if(node==null){
            return -1;
        }
        //判断条件，flag为false，也返回
        if(!flag){
            return -1;
        }
        int left=dept(node.left);
        int right=dept(node.right);
        //判断不平衡的逻辑
        if(Math.abs(left-right)>1){
            flag=false;
        }
        //每次返回的长度是其左右子树的最大长度再加1
        return Math.max(left,right)+1;
    }
}
