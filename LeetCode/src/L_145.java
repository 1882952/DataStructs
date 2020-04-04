import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
94：中序  144：前序
* 给定一个二叉树，返回它的 后序 遍历。  左-右-根
*   思路：还是考虑用栈，不同的是每次要利用上一次遍历的节点，所以用peek方法(返回栈顶元素但不弹出)
* */
public class L_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> lists=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode last=null;

        while (cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                TreeNode temp=stack.peek();
                //是否变到右树
                if(temp.right!=null && temp.right!=last){
                    cur=temp.right;
                }else {
                    lists.add(temp.val);
                    last=temp;
                    stack.pop();
                }
            }
        }

        return lists;
    }
}
