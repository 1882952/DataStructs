package 二零年五月;
/*
    节点与其祖先的最大差值
* 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
（如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）

思路：使用全局变量保存最大差值，然后递归，每次递归查找当前路径的最大值与最小值，到达叶子节点时，使用当前路径的最大值与
最小值更新全局变量。   因为从根节点开始，所以考虑前序遍历。
* */
public class Leetcode1026 {
    int res=Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return -1;
        }
        getMax(root,root.val,root.val);
        return res;
    }

    /** 采用前序遍历的方式
     *  递归公式 ；f（n）= 找出当前节点所在链的最大值与最小值,如果到达叶子节点，是否更新res    和  f（n.left） 和  f(n.right)
     * @param root 当前节点
     * @param min 当前链上的最小值
     * @param max 当前链上的最大值
     */
    private void getMax(TreeNode root,int min,int max){
        if(root==null){
            return;
        }
        max=Math.max(root.val,max);
        min=Math.min(root.val,min);
        //是否到达了叶子节点
        if(root.left==null && root.right==null){
            res=Math.max(res,Math.abs(max-min));
        }
        getMax(root.left,min,max);
        getMax(root.right,min,max);
    }

    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
