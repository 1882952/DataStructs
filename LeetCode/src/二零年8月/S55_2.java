package 二零年8月;

/**判断是否为平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 * 思路 ：递归实现，
 *      采用后序遍历的思路 ： 1：root的左子树是平衡的
 *                         2：root的右子树是平衡的
 *                         3： root的左右子树的深度差不超过1
 *      所以还得有一个求树的深度的方法。
 */
public class S55_2 {

    public boolean isBalanced(TreeNode root) {
        if(root==null){ //当前节点为空，返回true
            return true;
        }

        if(!isBalanced(root.left)){ //左子树不为平衡树
            return false;
        }
        if(!isBalanced(root.right)){ //右子树不为平衡树
            return false;
        }

        int l=depth(root.left);
        int r=depth(root.right);

        return Math.abs(r-l)>1 ? false : true;
    }

    //求树最大的深度
    private int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(depth(node.left),depth(node.right))+1;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
