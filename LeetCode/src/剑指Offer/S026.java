package 剑指Offer;

/**
 *
 *  树的子结构
 *  输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 *思路：这道题的思路，还是使用递归回溯的思想，问题是还是要想清树的结构；
 *     我们可以这样判断，判断树的A树的当前节点是不是B树的根节点，
 *                    A树的左子树节点是不是B树的根节点
 *                    A树的右子树节点，是不是B树的的根节点
 *                    然后递归判断就行
 *     本题的意义在于，更容易清晰理解树的结构概念，层级关系，也可以加深递归回溯的概念。
 */
public class S026 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B!=null) && (rescure(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    private boolean rescure(TreeNode a,TreeNode b){
        if(b == null){  // 如果b的当前位置节点是空，默认证明为true
            return true;
        }

        if(a == null){
            return false;
        }

        if(a.val == b.val){  // 比较当前节点后，递归比较左右子树节点是否正确
            return  rescure(a.left,b.left) && rescure(a.right,b.right);
        }else {
            return false;
        }
    }

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
