package 汇总.树.二叉树;

import java.util.*;

/*
* 层次遍历
* 使用 BFS 进行层次遍历。不需要使用两个队列来分别存储当前层的节点和下一层的节点，
* 因为在开始遍历一层的节点时，当前队列中的节点数就是当前层的节点数，
* 只要控制遍历这么多节点数，就能保证这次遍历的都是当前层的节点。
* */
public class BinaryTree4 {
    //1. 一棵树每层节点的平均数
    //解法，使用BfS层序遍历，维护一个队列 ,每递归一次添加每层的节点
    public List<Double>averageOfLeaves(TreeNode root){
        List<Double> ret=new ArrayList<>();
        if(root==null){
            return ret;
        }
        Queue<TreeNode> queue=new PriorityQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int cnt=queue.size();  //保存着每层添加节点的数目
            double sum=0;
            for (int i = 0; i <cnt ; i++) {
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ret.add(sum/cnt); //添加每一层的平均数
        }
        return ret;
    }

    //2. 得到左下角的节点
    /*
    *Input:
        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
Output:  可以发现，左下角的节点就是最后一层的首个节点，添加到最后一层后直接返回首个节点就行
7
    * */
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            root=queue.poll();
            if(root.right!=null){
                queue.add(root.right);
            }
            if (root.left!=null){
                queue.add(root.left);
            }
        }
        return root.val;
    }
}
