package 二零年8月;


/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 *满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 思路：这时不是二叉搜索树，但是还可以用同样的递归思路解决问题。
 *      总共有三种情况：（1）：p，q在root的子树中，且分别位于root的异侧。
 *                   （2）：p==root，且q在root的左或者右子树中；
 *                   （3）：q==root，且p在root的左或者右子树中。
 *考虑到这三种情况，所以采用后序遍历的思路解决问题，左--右----根，从底向返回，比如当节点p，q在节点root的异侧时，找到最近公共祖先，即root，节点向上返回root
 */
public class S68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //四种情况,逆向思维
        if(left==null && right==null){ //说明 rootroot 的左 / 右子树中都不包含 p,q ，返回 null ；
            return null;
        }
        if(left==null){ //p,q都不在root的左子树，直接返回右子树即可
            return right;
        }
        if(right==null){ //p,q都不在root的右子树，直接返回左子树即可
            return left;
        }
        return root; //2. if(left != null and right != null),说明p，q在root的异侧，root即为最近公共祖先，那么直接返回root即可
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
