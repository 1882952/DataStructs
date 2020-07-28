package 二0年七月;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;

/*
* 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
*
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
*
* 思路：前序遍历 ： 根--左--右
*      中序遍历 ： 左--根--右
*
*   采用分治思想来解决问题，  首先总结规律：在前序遍历中，根节点是数组的第一个元素， 在中序遍历中，根节点刚好在左右子节点的中间。
*  所以现在可以确定三个节点： 树的根节点，左子树的根节点，右子树的根节点,同时可以通过中序遍历确定左子树长度和右子树长度。
*  根据这个特点，可以通过同样的方法对左右子树进行划分，每轮可以确定三个节点的关系，由此可以想到递归。
*
*   同时可以设置一个map，用于保存并查找中序遍历数组中的值
*
* 总结：利用中序遍历数组确定根节点的下标，左子树和右子树的长度，然后利用前序遍历的递归方式去重组数组。

* */
public class S007 {
    Map<Integer, Integer> map=new HashMap<>(); //保存中序遍历数组的集合
    int [] po; //前序遍历数组的中间变量

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po=preorder;
        for (int i = 0; i <inorder.length ; i++) {
            map.put(inorder[i],i);
        }
        return recur(0,0,inorder.length-1);
    }

    /**
     * 递归函数，通过前序和中序可以找到的三个节点的关系，进行递归。
     * 递归的终止条件是左边界值in_left大于右边界值in_right
     * @param pre_root 前序遍历中根节点的索引值
     * @param in_left 中序遍历左边界索引值
     * @param in_right 中序遍历右边界索引值
     * @return
     *
     * 比如第一层：recur（0,0,4）
     *    第二层： recur（1,0,0） 和 recur(2,2,4) ，画图可清晰理解
     */
    TreeNode recur(int pre_root,int in_left, int in_right){
        if(in_left>in_right){
            return null;
        }
        TreeNode root=new TreeNode(po[pre_root]); //从前序遍历数组中找到当前层的根节点
        int i=map.get(po[pre_root]); //从map中找到当前层根节点在中序遍历数组中的下标
        //递归(按照根左右，即前序的递归)
        root.left=recur(pre_root+1,in_left,i-1);
        root.right=recur(pre_root+i-in_left+1,i+1,in_right);  //pre_root+i-in_left+1:  根节点索引 + 左子树长度 + 1
        return root;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
