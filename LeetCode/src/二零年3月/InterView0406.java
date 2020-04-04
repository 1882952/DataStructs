package 二零年3月;

import java.util.Stack;

/*
* 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
如果指定节点没有对应的“下一个”节点，则返回null。
示例 1:
输入: root = [2,1,3], p = 1

  2
 / \
1   3
输出: 2
示例 2:
输入: root = [5,3,6,2,4,null,null,1], p = 6
      5
     / \
    3   6
   / \
  2   4
 /
1
输出: null

思路：还是；利用中序遍历，每次判断其左子节点和cur是否存在

    也是和上道题一样，利用中序遍历的思路，按照左根右，判断左之上的根是否存在。
可以利用递归解决，本题用了迭代。  思路是将所有左子节点压入到栈中，利用pre变量
保存每次栈弹出的节点的左子节点值，即就是此题中的p的值，判断其是否相等就行。
  重点在于栈从根节点一直压入左子节点的逻辑，如果当前节点的右子节点不为空，也需要
把右子节点上的所有左子节点压入到栈中判断，就相当于用栈把此树变形为仅保留左子节点与
中间节点的比较，水平有限，自己也很菜，讲不出个所以然，总之简单地画一下流程大概就能
明白了。
* */
public class InterView0406 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        int pre=-1;
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
        TreeNode temp=null;
        while (!stack.isEmpty()){
            temp=stack.pop();
            if(p.val==pre){
                return temp;
            }
            pre=temp.val;
            //如果temp的右节点不为空，将temp右节点上的所有左子节点压入栈中
            if(temp.right!=null){
                TreeNode r=temp.right;
                while (r!=null){
                    stack.push(r);    //这部相当于把右子节点也作为了（当层根）加入到栈中，并不断加入左子节点
                    r=r.left;
                }
            }
        }
        return null;
    }
}
