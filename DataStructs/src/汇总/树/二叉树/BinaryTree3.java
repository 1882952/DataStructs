package 汇总.树.二叉树;

public class BinaryTree3 {
        //11. 统计左叶子节点的和
        /*
        *   3
           / \
          9  20
            /  \
           15   7
           There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
           9和15是左叶子节点，求其和返回

           左子节点分为左子树的左子节点与右子树的左子节点，需要把这两种左子节点全部找出并求和
        * */
        public int sumofLEftLeaves(TreeNode root){
            if(root==null){
                return 0;
            }
            if(isLeaf(root.left)){ //判断该节点的左子节点是不是左子节点
                return root.left.val+sumofLEftLeaves(root.right); //返回当前节点的左子节点与其右树的左子节点之和
            }
            return sumofLEftLeaves(root.left)+sumofLEftLeaves(root.right);
        }
        //判断某个节点是不是左子节点
        private boolean isLeaf(TreeNode node){
            if(node==null){
                return false;
            }
            return node.left==null && node.right==null;
        }

        //12:相同节点值的最大路径
        /*
        *    1
            / \
           4   5
          / \   \
         4   4   5
    这里为左4--4---4右 ，所以最大路径为2
Output : 2  ,利用深度优先完成
        * */
        private int path=0;
        public int longestUnivaluePath(TreeNode root){
            dfs(root);
            return path;
        }
        private int dfs(TreeNode root){
            if (root==null) return 0;
            int left=dfs(root.left);
            int right=dfs(root.right);
            //判断左边相同节点值的路径长度 (即左子节点要与当前节点的值相等)
            int leftPath=root.left!=null && root.left.val==root.val ? left+1 : 0;
            //同理，判断右边相同节点值的路径长度
            int rightPath=root.right!=null && root.right.val==root.val? right+1 : 0;
            path=Math.max(path,leftPath+rightPath);  //path指的是该树最长的路径，是返回的所求值

            //每次返回的是当前节点符合条件的最长子树，以作为回朔到上一层作为其子树的长度
            return Math.max(leftPath,rightPath);
        }

        //13:间隔遍历
        /*
        *    3
            / \
           2   3
            \   \
             3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

思路就是分两种情况，第一种情况：包含当前节点的间隔节点之和（比如图中的第一层与第三层节点之和 3，3，1）
                    第二种情况：不包含当前节点的左右子节点之和（比如图中的第二层间隔节点之和 2，3）
            * */
        public int rob(TreeNode root){
            if(root==null){
                return 0;
            }
            int val1=root.val;  //保存当前节点的值
            if(root.left!=null){  //第一种情况
                val1+=rob(root.left.left)+rob(root.left.right);
            }
            if(root.right!=null){
                val1+=rob(root.right.left)+rob(root.right.right);
            }
            //第二种情况
            int val2=rob(root.left)+rob(root.right);  //当前节点的左右子节点也是间隔节点

            return Math.max(val1,val2);
        }

        //14. 找出二叉树中第二小的节点(属于二叉查找树)
        /*
        * Input:
               2
              / \
             2   5
                / \
                5  7
        Output: 5,
            一个节点要么具有 0 个或 2 个子节点，如果有子节点，因为是个查找树，
         那么根节点是最小的节点,第二小的节点肯定是其左右子节点中的一个
        * */
        public int findSecondMinimumValue(TreeNode root){
            if (root==null){
                return -1;
            }
            if(root.left==null && root.right==null){
                return -1;
            }
            //找到当前节点的子节点的值
            int leftVal=root.left.val;
            int rightVal=root.right.val;
            //如果左子节点值等于当前节点，就继续查找其左子节点
            if(leftVal==root.val){
                leftVal=findSecondMinimumValue(root.left);
            }
            //同理，继续找其右子节点
            if(rightVal==root.val){
                rightVal=findSecondMinimumValue(root.right);
            }
            //返回的判断，三种情况，左右子节点都存在，取最小， 只有左结点存在，取左结点  最后一种情况肯定是返回右节点
            if(leftVal!=-1 && rightVal!=-1){
                return Math.min(leftVal,rightVal);
            }
            if (leftVal != -1){
                return leftVal;
            }
            return rightVal;
        }
}
