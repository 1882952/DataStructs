package 二零年五月;
/*
验证二叉搜索树
* 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

思路：一：利用中序遍历，如果中序遍历得到的节点小于前一个节点，那么就不是BST。 这个方式可以使用栈的中序遍历方法
思路二：使用前序遍历的递归，根-左-右， 传入三个参数，代表根节点，左节点值与右子节点的值。
* */
public class Leetcode98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    //采用前序遍历，根，左，右的判断方式。
    private boolean dfs(TreeNode node,long lower,long upper){
        if(node==null){
            return true;
        }
        if(node.val<=lower || node.val>=upper){
            return false;
        }
        if(!dfs(node.left,lower,node.val)){
            return false;
        }
        if(!dfs(node.right,node.val,upper)){
            return false;
        }
        return true;
    }

    class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}
