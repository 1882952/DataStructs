package 剑指Offer;

/**
 * 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
    思路：采用递归的思想， f(n) =  f（n左） 替换 f（n右）
 */
public class S027 {

    public TreeNode mirrorTree(TreeNode root) {
         if(root == null){
             return  root;
         }
         return rescure(root);
    }

    private TreeNode rescure(TreeNode node){
        if(node == null){
            return node;
        }
        TreeNode left = rescure(node.left);
        TreeNode right = rescure(node.right);
        TreeNode temp = left;
        node.left = right;
        node.right = temp;
        return node;
    }

     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
