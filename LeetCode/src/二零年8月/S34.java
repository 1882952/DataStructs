package 二零年8月;


import java.util.LinkedList;
import java.util.List;

/*
* 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶子节点所经过的节点形成一条路径。

思路：采用深度优先遍历, 也可以采用先序遍历+路径统计的方式来解决问题
 * */
public class S34 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>(); //中间容器

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,sum);
        return res;
    }

    void recur(TreeNode root,int tar){
        if(root==null){
            return;
        }
        path.add(root.val);
        tar-=root.val;
        if(tar==0 && root.left==null && root.right==null){ //直到叶子节点时，满足tar=0才能是一条路径
            res.add(new LinkedList<>(path));
        }
        recur(root.left,tar);
        recur(root.right,tar);

        //回朔时清除中间容器path的值，以便下一次迭代
        path.removeLast();
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
