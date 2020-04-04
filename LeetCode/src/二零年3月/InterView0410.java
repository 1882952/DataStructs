package 二零年3月;
/*
* 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，
* 判断 T2 是否为 T1 的子树。
如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，
得到的树与 T2 完全相同。
示例1:
 输入：t1 = [1, 2, 3], t2 = [2]
 输出：true
示例2:
 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 输出：false

思路：还是利用递归，遍历t1中的每个节点，判断以t1中每个节点为根的子树是否与t2相等
* */
public class InterView0410 {

    //以t1中的一个节点为根，然后与t2递归比较
    private boolean isSame(TreeNode troot,TreeNode t2){
        if(troot==null && t2==null){  //已经递归完了，说明这棵t1的子树与t2相等，返回true
            return true;
        }
        if(troot==null || t2==null){ //适用于troot已经递归完了，而t2还存在节点，或者相反情况，所以返回false
            return false;
        }
        return troot.val==t2.val && isSame(troot.left,t2.left) && isSame(troot.right,t2.right);
    }

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2==null;
        }
        //遍历t1中的每个节点，判断以t1中每个节点为根的子树是否与t2相等
        return isSame(t1,t2) || checkSubTree(t1.left,t2) || checkSubTree(t1.right,t2);
    }
}
