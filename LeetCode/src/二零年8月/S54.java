package 二零年8月;

/**
 * 二叉树的第K大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  思路: （1）先根据中序遍历得到数组，然后利用小顶堆获取第K大个节点
 *        （2）利用中序遍历的倒序 右--根--左 找到第K大个节点
 */
public class S54 {
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        dfs(root);
        return res;
    }
    //根据中序遍历的倒序规则找到第k
    private void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.right);
        if(k==0){
            return;
        }
        if(--k==0){
            this.res=root.val;
        }
        dfs(root.left);
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
