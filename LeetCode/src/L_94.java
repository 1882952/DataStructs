import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树，返回它的中序 遍历。

思路：
* 如果采用非递归，可以用栈(Stack)的思路来处理问题。
中序遍历的顺序为左-根-右，具体算法为：
从根节点开始，先将根节点压入栈
然后再将其所有左子结点压入栈，取出栈顶节点，保存节点值
再将当前指针移到其右子节点上，若存在右子节点，则在下次循环时又可将其所有左子结点压入栈中， 重复上步骤
* */
public class L_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        while (curr !=null || !stack.isEmpty()){
            //将左结点依次压入
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            curr=stack.pop();
            list.add(curr.val);
            curr=curr.right;
        }
        return list;
    }
}
