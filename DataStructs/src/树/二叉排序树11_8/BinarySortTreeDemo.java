package 树.二叉排序树11_8;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] array={7,3,10,12,5,1,9,2};
        BinarySortTree bs=new BinarySortTree();
        for (int i = 0; i <array.length ; i++) {
            bs.addNode(new Node(array[i]));
        }
        bs.infixOrder();
        System.out.println("----------------------");
        bs.delNode(10);
        bs.infixOrder();
    }
}
class BinarySortTree{
    private Node root;
    //查找要删除的节点
    public Node search(int value){
        if(root==null){
            return null;
        }
        return root.search(value);
    }
    //查找要删除删除节点的父节点
    public Node parentSearch(int value){
        if(root==null){
            return null;
        }
        return root.parentSearch(value);
    }
    //方法：返回以node为根节点的二叉排序树的最小节点的值，删除以node为根节点的二叉排序树的最小节点
    public int delRightTreeMin(Node node){
        Node target=node;
        //循环地查找左子结点，找到最小值
        while (target.left!=null){
            target=target.left;
        }
        //删除最小节点
        delNode(target.value);
        return target.value;
    }
    //删除节点
    public void delNode(int value){
        if(root==null){
            return;
        }
        //需求：找到要删除的节点
        Node targetNode=search(value);
        if(targetNode==null){
            return;
        }
        //如果发现当前这颗二叉排序树只有一个节点(要删除的节点没有父节点),即要删除的节点是root节点
        if(root.left==null && root.right==null){
            root=null;
            return;
        }
        //找到要删除节点的父子节点
        Node parent=parentSearch(value);
        //第一种情况：如果要删除的节点是叶子节点
        if(targetNode.left==null && targetNode.right==null){
            //判断targetNode是父节点的左子节点，还是右子节点
            if(parent.left!=null && parent.left.value==value){
                parent.left=null;
            }else if(parent.right!=null && parent.right.value==value){
                parent.right=null;
            }
        }else if (targetNode.left!=null && targetNode.right!=null){ //第三种情况：删除有两颗子树的节点
            //找到要删除节点右子树的的最小值
            int minVal=delRightTreeMin(targetNode.right);
            targetNode.value=minVal;
        }else { //第二种情况：删除只有一颗子树的节点（因为判断条件过长，所以在排除其他情况在else中写）
            //如果要删除的节有左子节点
            if(targetNode.left!=null){
                if(parent!=null){
                    if(parent.left.value==value){  //如果targetNode是parent的左子节点
                        parent.left=targetNode.left;
                    }else {  //targetNode是parent的右子节点
                        parent.right=targetNode.left;
                    }
                }else {  //删除的该节点没有父节点 (即要删除的节点是根节点，但是根节点有一颗子树)比如：10,3 删除10
                    root=targetNode.left;
                }
            }else{ //要删除的节点只有右子节点
                if(parent!=null){
                    if(parent.left.value==value){
                        parent.left=targetNode.right;
                    }else {
                        parent.right=targetNode.right;
                    }
                }else {
                    root=targetNode.right;
                }
            }
        }
    }
    public void addNode(Node node){
        if(root==null){
            root=node;
        }else {
            root.addNode(node);
        }
    }
    public void infixOrder(){
        if(root==null){
            System.out.println("该树不存在");
            return;
        }else {
            root.infixOrder();
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }
    //查找要删除的节点
    public Node search(int value){
        if(value==this.value){
            return this;
        }else if (value<this.value){
            if(this.left==null){
                return null;
            }
            return  this.left.search(value);
        }else {
            if(this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }
    //查找要删除节点的父节点
    public Node parentSearch(int value){
        if((this.left!=null && this.left.value==value) || (this.right!=null && this.right.value==value)){
            return this;
        }else {
            if(value<this.value && this.left!=null){
             return this.left.parentSearch(value);
            }else if(value>=this.value && this.right!=null){
                return this.right.parentSearch(value);
            }else {
                return null;
            }
        }
    }
    //添加节点,递归的形式添加节点，注意需要满足二叉排序树的要求
    public void addNode(Node node){
        if(node==null){
            return;
        }
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else {
                this.left.addNode(node);
            }
        }else {
            if(this.right==null){
                this.right=node;
            }else {
                this.right.addNode(node);
            }
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
