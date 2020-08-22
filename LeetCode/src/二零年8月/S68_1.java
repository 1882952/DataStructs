package 二零年8月;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 *思路： 就是比较p，q两节点在哪棵子树的根节点之下,因为该树是二叉搜索树，所以思路很方便
 *  方法（1）递归：1.当p，q都在root的右子树上，则开启递归返回root。right。
 *               2。当p，q都在root的左子树上，则开启递归返回root。left
 *      （2）迭代：将递归转为迭代代码即可
 */
public class S68_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val> root.val && q.val > root.val){ //在该树的右子树上查找
            return lowestCommonAncestor(root.right,p,q);
        }
        if(p.val<root.val && q.val<root.val){ //在该树的左子树上寻找
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
