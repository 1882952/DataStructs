package 汇总.树.二叉树;

import java.util.*;

//使用非递归的方式进行前序，中序，后序的遍历，，比较重要，之前刷力扣题的时候写过的，可以作为比较参考
//思路一般是  使用栈进行BFS深度优先
public class BinaryTree5 {
    //前序遍历   根--左--右
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ret=new ArrayList<>();
        //Stack类是继承自Vector，本质就是一个加了同步操作的数组结构，所以性能不强，可用LinkedList代替
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            //每次弹出根节点
            TreeNode node=stack.pop();
            if(node==null){
                continue;
            }
            //保存本次弹出的值
            ret.add(node.val);
            stack.push(node.right); //先压入右后压入左，保证左子树的最先弹出
            stack.push(node.left);
        }
        return ret;
    }

    //非递归实现后序遍历  ,因为后序是左--右--根，
    // 可以将上面的前序过程，栈压入的顺序，根--右--左，改一下，变为 根--右--左，这样将结果最后反转一下就是左---右---根了
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> ret=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node==null){
                continue;
            }
            ret.add(node.val);
            //注意解释中的左右压入栈的顺序
            stack.push(node.left);
            stack.push(node.right);
        }
        //最后将结果做一个反转，就可以完成左--右---根的遍历
        Collections.reverse(ret);
        return ret;
    }

    //中序遍历，  左---根---右,所以要先将左结点全部压入
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ret=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){
            //将这棵树上的所有左子节点压入
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode node=stack.pop();
            ret.add(node.val);
            //下一次循环时又可以将node右子节点上的所有左子节点压入栈中
            cur=node.right;
        }
        return ret;
    }
}
