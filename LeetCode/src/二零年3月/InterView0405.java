package 二零年3月;

import java.util.Stack;

/*
* 实现一个函数，检查一棵二叉树是否为二叉搜索树。
示例 1:
输入:
    2
   / \
  1   3
输出: true
示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

思路：，判断中序遍历是否递增，利用中序遍历打印该二叉树，
    可以利用常用二叉树递归遍历，然后再判断

也可利用栈实现，好处是不用数组保存数据
中序遍历，左-根-右，
具体算法为：
    将树的左子树依次存入stack
    每次pop出一个TreeNode，判断其是否大于之前的数
    将其右子树的左子树也依次存入stack

 这里不用保存输出结果，只需要比较节点的大小就行
* */
public class InterView0405 {
    public boolean isValidBST(TreeNode root) {
        long pre=Long.MIN_VALUE;
        Stack<TreeNode> stack=new Stack<>();
        //  将树的左子树依次存入stack
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            if(temp.val<=pre){
                return false;
            }
            pre=temp.val;
            //如果当前节点的right不等于null，就需要将其右节点的左子节点加入栈中
            if(temp.right!=null){
                TreeNode r=temp.right;
                while (r!=null){
                    stack.push(r);
                    r=r.left;
                }
            }

        }
        return true;
    }


    //这样写还是提交不了，有问题，遇到有null值的树会出错
    public boolean isValidBST1(TreeNode root){
        long pre=Long.MIN_VALUE;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null || stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            //从栈的最底层的最左节点依次往上弹出
            cur=stack.pop();
            if(cur.val<=pre){  //说明当前节点值小于其左子节点的值（每次都用pre保存其左子节点值）
                return false;
            }
            pre=cur.val;//将当前节点的值保存起来，到下一次栈弹出时与弹出时的节点值比较
            cur=cur.right;  //如果cur的右子节点不为空，则将其右子节点的左子节点也加入栈中
        }
        return true;
    }
}
