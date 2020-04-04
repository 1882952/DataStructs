package 汇总.树.二叉树;

public class BinaryTree2 {

    //统计路径和等于一个数的路径数量
    /*
    * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1
    Return 3. The paths that sum to 8 are:
    1.  5 -> 3
    2.  5 -> 2 -> 1
    3. -3 -> 11

    可以看出，路径不一定以root开头，也不一定以leaf结尾，只要保证连续
    * */
    public int pathSum(TreeNode root,int sum){
        if (root==null)  return 0;
        int ref=pathSumWithRoot(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
        return ref;
    }
    public int pathSumWithRoot(TreeNode root,int sum){
     if(root==null){
         return 0;
     }
     int ret=0;  //符合该数的路径条数
     if(sum==0){
         ret++;
     }
     ret+=pathSum(root.left,sum-root.val)+pathSum(root.right,sum-root.val);
     return ret;
    }

    //8:判断一个树是不是另一个树的子树
    /*
    * Given tree s:
         3
        / \
       4   5
      / \
     1   2
    Given tree t:
       4
      / \
     1   2
Return true, because t has the same structure and node values with a subtree of s.
Given tree s:
         3
        / \
       4   5
      / \
     1   2
        /
       0
Given tree t:
       4
      / \
     1   2
Return false.
    * */

    public boolean isSubTree(TreeNode s,TreeNode t){
        if(s==null){
            return false;
        }
        return isSubTreeWithRoot(s,t) || isSubTree(s.left,t.left) || isSubTree(s.right,t.right);
    }
    //按照两棵树对应的当前节点来递归
    public boolean isSubTreeWithRoot(TreeNode s,TreeNode t){
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null){
            return false;
        }
        if (t.val!=s.val){
            return false;
        }
        return isSubTreeWithRoot(s.left,t.left) && isSubTreeWithRoot(s.right,t.right);
    }

    //9:判断树是否对称,原理和 8 相同，将左右子树当成两子树判断是否相同
    public boolean symmertic(TreeNode root){
        if(root==null){
            return false;
        }
        return isSubTreeWithRoot(root.left,root.right);
    }

    //10. 最小路径 ,从树的根节点到叶子节点的最小路径长度
    public int minDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int l=minDepth(root.left);
        int r=minDepth(root.right);
        if(l==0 || r==0){   //证明该树只有一颗子树
            return l+r+1;
        }
        return Math.min(l,r)+1;
    }
}

