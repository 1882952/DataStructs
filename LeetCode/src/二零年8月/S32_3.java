package 二零年8月;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*
*   请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
* 第三行再按照从左到右的顺序打印，其他行以此类推。

    *思路：依然使用BFS，这时需要在 II 的基础上考虑奇偶，因为LinkeList可以在首部添加节点，也可以在尾部添加节点，所以可以利用这一点。

 * */
public class S32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null)  queue.add(root);
        while (!queue.isEmpty()){
            LinkedList<Integer> list=new LinkedList<>();
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode temp=queue.poll();
                if(lists.size()%2==0){  //如果是偶数层，则从右到左，添加到尾部
                    list.addLast(temp.val);
                }else {  //如果是奇数层
                    list.addFirst(temp.val);
                }

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
