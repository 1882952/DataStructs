package 汇总.树.二叉树;
//树的常见操作
public class BinaryTree {

    //1:求树的高度,递归求解
    //主要思路，递归到最后一层，然后返回，每次返回时+1，取左右子树最长的长度作为高度。
    public int maxTree(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(maxTree(root.getLeft()),maxTree(root.getRight()))+1;
    }

    private boolean result=true;
    //2:判断一棵树是不是平衡树,左右子树的高度差不能为超过1，从这点考虑,还是要求树的高度
    private boolean isBalance(TreeNode root){
        maxDepth(root);
        return result;
    }
    public int maxDepth(TreeNode root){
        if (root==null){return 0;}
        int left=maxDepth(root.getLeft());
        int right=maxDepth(root.getRight());
        if(Math.abs(left-right)>1){  //长度大于1，返回false
            result=false;
        }
        return Math.max(left,right)+1;
    }

    //3:两节点的最长路径
    /*    意思就是从底开始，可以走完所有相关节点向上回朔，  比如 从4---1，  4 2 1 3  这样就走了四步，
    * Input:
         1
        / \
       2  3
      / \
     4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

思路与2相似，只不过需要判断Max时，取的left+right的长度，本质是左子树长度加右子树长度
    * */
    public int diameterOfBinaryTree(TreeNode root){
        longDepth(root);
        return max;
    }
    private int max=0;
    public int longDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        int left=longDepth(root.getLeft());
        int right=longDepth(root.getRight());
        max=Math.max(max,left+right);  //最大长度为left+right的长度和
        return Math.max(left,right)+1;
    }

    //4:翻转树，就是把左子树和右子树交换，还是使用递归
    public TreeNode invertTree(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=root.getLeft(); //获取左子树节点
        root.left=invertTree(root.getRight());
        root.right=invertTree(left);
        return root;
    }
    //5:归并两颗树
    /*
    * Input:
       Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7

Output:
         3
        / \
       4   5
      / \   \
     5   4   7      将两颗树上的相应节点合并
    * */
    public TreeNode mergeTrees(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null){return null;}
        if(t1==null){ return t2;}
        if(t2==null){ return t1;}
        //合并两相同位置上的节点
        TreeNode node=new TreeNode(t1.val+t2.val);
        node.left=mergeTrees(t1.left,t2.left);
        node.right=mergeTrees(t1.right,t2.right);
        return node;
    }

    //6:判断路径和是否等于一个数,采用递归,
    /*
    * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    * */
    public boolean hashPathSum(TreeNode root,int sum){
        if(root==null){
            return false;
        }
        //路径和满足sum的条件
        if(root.left==null && root.right==null && root.val==sum ){
            return true;
        }
        return hashPathSum(root.left,sum-root.val) || hashPathSum(root.right,sum-root.val);
    }


}
