package 二零年3月;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，
* 打印节点数值总和等于某个给定值的所有路径的数量。
* 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，
* 但是其方向必须向下(只能从父节点指向子节点方向)。
示例:
给定如下二叉树，以及目标和 sum = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
3
解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
提示：
节点总数 <= 10000

思路：这道题用了一个概念，前缀和，就是到达当前元素的路径上，之前所有元素的和。

    如果两个数的前缀总和是相同的，那么这些节点之间的元素总和为0（定义，前缀和相同，则让元素和为0），
进一步扩展，如果前缀总和currentSum，在节点A和节点B处相差target，那么位于AB节点之间的元素之和为target。

    在抵达当前节点B节点之后，将前缀和累加，然后查找前缀和，有没有前缀和currentSum-target的节点（即A节点），
存在则说明从A到B有一条路径满足，将该情况保存，然后递归进入左右子树判断。

    左右子树遍历完成之后，回到当前层，需要把当前节点添加的前缀和去除。
    避免回溯之后影响上一层。因为思想是前缀和，不属于前缀的，我们就要去掉它。


    总结；本题是利用前缀和，然后递归到该节点的不同路径上判断是否有符合条件的支路，判断完毕则回朔返回，
    清空该节点的标记，让其不影响前缀和上其他支路的判断。
      具体来说，就是利用前缀和减去目标值，判断结果是否存在于这颗树上的某个节点。
* */
public class InterView0412 {

    public int pathSum(TreeNode root, int sum) {
        //先利用容器保存相应的前缀和，key是前缀和，value是当前前缀和上符合条件的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);  //前缀和为0的一条路径，如果curSum-target为0，表明从根节点起，所以先需要保存。

        return recursionPathSum(root,prefixSumCount,sum,0);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     *
     * @param node           树节点
     * @param prefixSumCount 前缀和Map
     * @param target         目标值
     * @param currSum        当前路径和
     * @return 满足题意的解
     */
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum){
        if(node==null){ //递归条件的返回
            return 0;
        }
        int res=0;  //本层要记的符合条件的个数，递归到最后一层，然后向上回朔，就可以基于res统计出符合条件的个数
        currSum+=node.val;      //当前路径上的和

        //核心逻辑
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res+=prefixSumCount.getOrDefault(currSum-target,0);  //如果不符合条件，则获取不到key
        //更新路径上当前节点和的个数,因为加了本层的node，所以产生一个新的currSum
        prefixSumCount.put(currSum,prefixSumCount.getOrDefault(currSum,0)+1);

        //进入下一层
        res+=recursionPathSum(node.left,prefixSumCount,target,currSum);
        res+=recursionPathSum(node.right,prefixSumCount,target,currSum);

        //最后回到本层，恢复状态，去掉当前节点的前缀和数量，因为要保证该节点的前缀和的其他路径不受影响
        prefixSumCount.put(currSum,prefixSumCount.get(currSum)-1);
        return res;
    }
}
