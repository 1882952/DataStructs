import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* 二叉树的前序遍历,非递归 ，根左右
* 思路：
* 也考虑使用栈，按照根左右的顺序 ，深度纵向
* 1：集合添加节点p
* 2:栈压入该节点p ;
* 3:p=p.left ,如果p不为空，循环12步骤;如果p为空,则弹出栈顶节点的右子节点循环123步骤
* 注意：弹出栈顶节点的右子节点的原因：存在最后一层没有左子节点而有右子节点
* */
public class L_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode p=root;
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> rev=new ArrayList<>();
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                rev.add(p.val);
                stack.push(p);
                p=p.left;
            }
            //弹出栈顶节点,并且让栈顶节点的右节点赋给p
            p=stack.pop().right;
        }
        return rev;
    }
}
