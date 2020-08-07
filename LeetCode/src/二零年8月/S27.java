package 二零年8月;

import java.util.Stack;

/*
* 二叉树的镜像：
* 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
*
* 例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：
     4
   /   \
  7     2
 / \   / \
9   6 3   1

* 思路：使用递归，替换左右子节点
*      或者使用辅助栈解决问题
* */
public class S27 {
    //利用递归，回朔的思路解决问题，首先保存左子节点，然后替换即可 ,  f(root)= f(root.left)《===》f(root.right)
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(tmp);
        return root;
    }
    //使用辅助栈解决问题,利用栈（或队列）遍历树的所有节点 nodenode ，并交换每个 nodenode 的左 / 右子节点。
    public TreeNode mirrorTree1(TreeNode root){
        if (root==null){
            return null;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>(){
            {
                add(root);
            }
        };
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null){
                stack.add(root.left);
            }
            if(node.right!=null){
                stack.add(root.right);
            }
            TreeNode tmp=node.left;
            node.left=node.right;
            node.right=tmp;
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
