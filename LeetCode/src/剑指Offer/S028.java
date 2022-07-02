package 剑指Offer;

/**
 * 对称二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 *  思路： 可以使用递归思路，  f(n) = f(n.left) 与 f(n.right)的值是否对称
 */
public class S028 {

    public boolean isSymmetric(TreeNode root) {
        return root == null ?true : recure(root.left,root.right);
    }

    private boolean recure(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right==null || left.val != right.val){
            return false;
        }
        return recure(left.left, right.right) && recure(left.right, right.left);
    }


     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
