import java.util.Stack;

/*
* 给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
示例：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

* */
public class L_104 {
    //迭代的dfs
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> value=new Stack<>();
        stack.push(root);
        value.push(1);
        int depth=0;
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            int temp=value.pop();
            depth=Math.max(depth,temp);
            if(node.left!=null){
                stack.push(node.left);
                value.push(temp+1);
            }
            if(node.right!=null){
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return depth;
    }
}
