package 二零年8月;
/*
    树的子结构

* 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

思路：采用前序遍历加递归的方式解决问题。 求解过程大致分为两步：根节点匹配，然后对子树匹配。
* */
public class S26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return  (A!=null && B!=null) && (rescur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    private boolean rescur(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null || A.val!=B.val){
            return false;
        }
        return rescur(A.left,B.left) && rescur(A.right,B.right);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
