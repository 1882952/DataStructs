package 二零年8月;

/*
* 对称二叉树
* 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
*
* 思路：也就是满二叉树的判断,对称可以使用值对称进行判断
* */
public class S28 {

    public boolean isSymmetric(TreeNode root) {
        return root==null ? true : rescur(root.left,root.right);
    }

    public boolean rescur(TreeNode l, TreeNode r){
        if(l==null && r==null){
            return true;
        }
        if(l==null || r==null || l.val!=r.val){
            return false;
        }
        return rescur(l.left,r.right) && rescur(l.right,r.left);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
