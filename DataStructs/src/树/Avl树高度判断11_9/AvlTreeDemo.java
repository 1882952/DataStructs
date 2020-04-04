package 树.Avl树高度判断11_9;

public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] arr={4,3,6,5,7,8};  //单右子树高度差的情况
        int [] arr2={10,12,8,9,7,6}; //单左子树高度差的情况
        int[] arr3={10,7,11,6,8,9};  //左子树高度差下的右子树高度差
        int[] arr4={4,3,8,6,9,5};    //右子树高度差下的左子树高度差
        AvlTree atree=new AvlTree();
        for (int i = 0; i <arr.length; i++) {
            atree.addNode(new Node(arr[i]));   //测试时只改变arr数组就行
        }
        System.out.println("中序遍历");
        atree.infixOrder();
        System.out.println("树的高度"+atree.getRoot().height());
        System.out.println("左子树的高度"+atree.getRoot().leftHeight());
        System.out.println("右子树的高度"+atree.getRoot().rightHeight());
        System.out.println("当前树的根节点:"+atree.getRoot());

    }
}
class AvlTree{
    private Node root;
    public Node getRoot() {
        return root;
    }
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
    //返回左子树的高度
    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }
    //返回右子树的高度
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
    }
     //返回当前节点的高度，以该节点为根节点的这颗树的高度
    public int height(){
        return Math.max(left==null ? 0:left.height(),right==null ? 0 : right.height())+1;
    }
    //左旋转
    private void leftRotate(){
        //创建新的节点，以当前根节点的值
        Node newnode=new Node(this.value);
        //把新的节点的左子树，设置为当前节点的左子树
        newnode.left=this.left;
        //把新的节点的右子树设置为当前节点的右子树的左子树
        newnode.right=this.right.left;
        //把当前节点的值替换成右子节点的值
        this.value=this.right.value;
        //把当前节点的右子树设置为当前节点的右子树的右子树
        this.right=this.right.right;
        //把当前节点的左子树设置为新节点
        this.left=newnode;
    }
    //右旋转
    private void rightRotate(){
        //创建新的节点，以当前根节点的值
        Node newnode=new Node(this.value);
        //把新的节点的右子树，设置为当前节点的右子树
        newnode.right=this.right;
        //把新的节点的左子树设置为当前节点的左子树的右子树
        newnode.left=this.left.right;
        //把当前节点的值换为左子节点的值
        this.value=this.left.value;
        //把当前节点的左子树设置为当前节点的左子树的左子树
        this.left=this.left.left;
        //把当前节点的右子树设置为新的节点
        this.right=newnode;
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
        //当添加完一个节点后，如果其右子树的高度-左子树的高度>1，发生左旋
        if(this.rightHeight()-this.leftHeight()>1){
            //如果它的右子树的左子树高度大于它的右子树的右子树高度,先对右子树右旋，再对当前节点左旋
            if(this.right!=null && this.right.leftHeight()>this.right.rightHeight()){
                this.right.rightRotate();
                this.leftRotate();
            }else {
                this.leftRotate();
            }
            return;
        }
        //当添加完一个节点后，如果其左子树的高度-右子树的高度>1，发生右旋
        if(this.leftHeight()-this.rightHeight()>1){
            //如果它的左子树的右子树高度大于它的左子树的左子树高度，需要双旋转，先对左子树左旋,再对当前节点右旋
            if(this.left!=null && this.left.rightHeight()>this.left.leftHeight()){
                this.left.leftRotate();
                this.rightRotate();
            }else {
                this.rightRotate();
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
