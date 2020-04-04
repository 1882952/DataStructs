package 二零年3月;
/*
* 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
* 不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
    3
   / \
  5   1
 / \ / \
6  2 0  8
  / \
 7   4
示例 1:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输入: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
说明:
所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

思路，这种在二叉树中查找节点的题目，肯定要联系到前中后序遍历，说起遍历，马上联想到递归和迭代这
两种方式，本题用递归解决，所以思路与过程都比较简便。
因为要找到公共祖先节点，那么就要判断这两个节点在当前左右子树上，还是都在左子树上，还是都在右子树上。
利用根左右的前序遍历思路，遇到符合p,q的节点，直接返回，然后再利用递归返回后回到上层后做当前节点的左右子节点
判断，重点是理清递归思路，对二叉树的左右子节点递归灵活使用。
*
* 递归递归，自底而上，切记切记。
* */
public class InterView0408 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //本质就三种情况，两节点在当前节点的左右子树中，两节点都在左子树中，两节点都在右子树中

        if(root==null || p==null || q==null){  //当前节点为null，返回
            return null;
        }
        if(root.val==p.val || root.val==q.val){  //当前节点的值为p或者q，说明已经找到一个节点，返回该节点停止该层递归
            return root;
        }
        //分别去左右子树里面找
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){  //如果左右子树里各有一个p或者q，那么当前节点就是祖先节点
            return root;
        }else if(left==null){ //如果左边为空，那么就是这个右边的
            return right;
        }else if(right==null){ //如果右边为空，那么就是这个左边的
            return left;
        }
        return null;  //要么就是left，right全为空，返回null即可
    }
}
