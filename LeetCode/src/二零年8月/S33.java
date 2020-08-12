package 二零年8月;

import java.util.concurrent.PriorityBlockingQueue;

/*
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
*
* 思路：后续遍历那就是 左-右--根， 根据根 > 左，根< 右的关系，可以使用递归分治算法。
*
*  也可以使用辅助单调栈
* */
public class S33 {

    //使用递归分治法
    public boolean verifyPostorder(int[] postorder) {
        return recure(postorder,0,postorder.length-1);
    }

    private boolean recure(int [] postorder,int i,int j){
        if(i>=j){ //此时说明此子树节点小于等于1，无需判断正确性，直接返回true
            return true;
        }
        int p=i;
        while (postorder[p]<postorder[j]){ //在数组序列找到当前root的第一个右子树的节点
            p++;
        }

        int m=p; //保存右子树节点区域的在数组中的左边界
        while (postorder[p]>postorder[j]){ //找到最后一个右子树节点的边界
            p++;
        }
        return p==j && recure(postorder,i,m-1) && recure(postorder,m,j-1); //判断p是否为根节点以及左子树与右子树的比较
    }
}
