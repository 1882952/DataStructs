package 二0年4月;

import javax.swing.tree.TreeNode;

/*
* 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
* 实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，
* 也就是在原始的二叉搜索树上直接修改。
返回转换后的单向链表的头节点。
注意：本题相对原题稍作改动
示例：
输入： [4,2,5,1,3,null,6,0]
输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]

思路，中序遍历，然后添加到一个TreeNode构成的单链表中。
利用一个前驱节点完成。 前驱节点每次都是按照 左---中---右指向。
* */
public class InterView1712 {
    public TreeNode convertBiNode(TreeNode root) {
        TreeNode head=new TreeNode(0); //定义一个哨兵节点
        inorder(root,head);
        return head.right;
    }
    private TreeNode inorder(TreeNode node,TreeNode prev){
        if(node!=null){
            prev=inorder(node.left,prev);
            node.left=null;
            prev.right=node;
            prev=node;
            prev=inorder(node.right,prev);
        }
        return prev;
    }
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
  }
}
