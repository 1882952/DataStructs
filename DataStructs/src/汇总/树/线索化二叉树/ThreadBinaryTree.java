package 汇总.树.线索化二叉树;

public class ThreadBinaryTree {
    private Node preNode;  //记录前缀

    static class Node{
        String data;        //数据域
        Node left;          //左指针域
        Node right;         //右指针域
        boolean isLeftThread = false;   //左指针域类型  false：指向子节点、true：前驱或后继线索
        boolean isRightThread = false;  //右指针域类型  false：指向子节点、true：前驱或后继线索

        Node(String data) {
            this.data = data;
        }
    }
    //创造一个二叉树（完全二叉树）
    public static Node creatBinaryTree(String [] array,int index){
        Node node=null;
        if(index<array.length){
            node=new Node(array[index]);
            node.left=creatBinaryTree(array,2*index+1);
            node.right=creatBinaryTree(array,2*index+2);
        }
        return node;
    }

    //中序化线索二叉树，使用递归  ,左--根--右  ,利用pre前驱，最终将节点串成一条链
    void inThreadOrder(Node node){
        if(node==null){
            return;
        }
        if(node.left!=null){
            inThreadOrder(node.left);
        }

        //因为中序，所以先利用空的左指针,将其指向前驱节点
        if(node.left==null){
            node.left=preNode;
            node.isLeftThread=true;
        }

        //前一个节点的后继节点（有效的时候）指向当前节点
        if(preNode!=null && preNode.right==null){
            preNode.right=node;
            preNode.isRightThread=true;
        }
        preNode=node;  //最终将pre指向当前节点，作为下次递归的前驱节点

        if(node.right!=null){
            inThreadOrder(node.right);
        }
    }

    //中序线索化二叉树的遍历1，（按照后继节点来遍历）
    //要是看不明白，就画图，可以看作是左边一条链，右边也是一条链，两条链都指向root
    void inThreadList(Node node) {
        while (node != null) {
            //因为是中序线索化，所以要先找到最左的节点
            while (!node.isLeftThread){
                node=node.left;
            }
            System.out.println(node.data);
            while (node.isRightThread) {
                node = node.right;
                System.out.println(node.data);
            }
            node = node.right;
        }
    }
}
