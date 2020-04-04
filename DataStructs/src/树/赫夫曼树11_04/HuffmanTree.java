package 树.赫夫曼树11_04;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree{
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        Node root=creatHuffmanTree(arr);
        preOrder(root);
    }
    //创建赫夫曼树
    public static Node creatHuffmanTree(int[] arr){
        //第一步：将arr数组中的每个元素构成一个node，将node放入ArrayList中
        List<Node> nodes=new ArrayList<>();
        for (int value: arr) {
            nodes.add(new Node(value));
        }
        //整个过程是一个循环的过程，创建到最后，集合中只剩下最后一个节点
        while (nodes.size()>1){
        //排序，从小到大（排序规则取决于compareTo方法）
        Collections.sort(nodes);
        //取出根结点权值最小的两颗二叉树
        //(1)取出权值最小的节点（二叉树）
        Node leftNode=nodes.get(0);
        //(2)取出权值第二小的节点（二叉树）
        Node rightNode=nodes.get(1);
        //(3)构建一颗新的二叉树
        Node parent=new Node(leftNode.value + rightNode.value);
        parent.left=leftNode;
        parent.right=rightNode;
        //删除集合中的已使用过的节点
        nodes.remove(leftNode);
        nodes.remove(rightNode);
        //(4)将parent加入到集合nodes中
        nodes.add(parent);
        }
        //返回哈夫曼树的最后一个节点
        return nodes.get(0);
    }
    //前序遍历的方法
    public static void preOrder(Node node){
        if(node!=null){
            node.preOrder();
        }else {
            System.out.println("该树是空树");
        }
    }
}
//为了让Node对象持续排序collections集合排序
//让node实现Compareable接口
class Node implements Comparable<Node>{
    int value; //节点权值
    Node left;  //指向左子节点
    Node right; //指向右子节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value-o.value;
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();;
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}
