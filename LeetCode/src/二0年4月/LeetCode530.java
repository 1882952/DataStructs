package 二0年4月;
/*
* 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
* 思路：因为是BST，所以可以利用中序遍历解决问题。
* 记录好上一个节点pre，每当遍历到当前节点，与pre节点相减即可。
* */
public class LeetCode530 {
    private int min=Integer.MAX_VALUE;
    private int pre=-1;
    public int getMinimumDifference(TreeNode root) {
        return getmin(root);
    }
    //采用中序遍历完成
    private int getmin(TreeNode node){
        if(node==null){
            return -1;
        }
        getmin(node.left);
        if(pre!=-1){
            int abs=Math.abs(node.val-pre);
            min=Math.min(min,abs);
        }
        pre=node.val; //将当前值保存
        getmin(node.right);
        return min;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
 }
}
