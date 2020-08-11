package 二零年8月;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

*  ：思路：依然是bfs,与上一道题的区别在于，每一层都需要装进一个集合，这就需要遍历每一层
* */
public class S32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null)  queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!= null){
                    queue.add(temp.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
