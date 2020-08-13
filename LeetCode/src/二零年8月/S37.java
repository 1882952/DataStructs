package 二零年8月;

import java.util.LinkedList;
import java.util.Queue;

/*
* 序列化与反序列化二叉树2
*
* 请实现两个函数，分别用来序列化和反序列化二叉树。
* 思路：需要考虑层序遍历，序列化与反序列化的函数是可逆的
*
* 这里用字符串的常用处理操作来实现，需熟悉相关字符串操作
* */
public class S37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "[]";
        }

        StringBuilder str=new StringBuilder("[");
        Queue<TreeNode> queue=new LinkedList<TreeNode>(){{add(root);}};
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if(temp!=null){
                str.append(temp.val+",");
                queue.add(temp.left);
                queue.add(temp.right);
            }else {
                str.append("null,");
            }
        }
        str.deleteCharAt(str.length()-1);
        str.append("]");
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")){
            return null;
        }
        String [] strs=data.substring(1,data.length()-1).split(",");
        TreeNode root=new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue=new LinkedList<TreeNode>(){{add(root);}};
        int i=1;
        //根据层序遍历的顺序依次添加链接节点的左右子节点
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(!strs[i].equals("null")){
                node.left=new TreeNode(Integer.parseInt(strs[i]));
                queue.add(node.left);
            }
            i++;
            if(!strs[i].equals("null")){
                node.right=new TreeNode(Integer.parseInt(strs[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
