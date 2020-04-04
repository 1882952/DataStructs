package 树.二叉树10_26.二叉树review;
//TreeNode节点,仅仅作为节点，不要在里面做过多操作，有问题的
public class TreeNode {
    private String val;
    private TreeNode left;
    private TreeNode right;

    public String getVal() {
        return val;
    }
    public void setVal(String val) {
        this.val = val;
    }

    public TreeNode(String val) {
        this.val = val;
    }
    public TreeNode getLeft() {
        return left;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
    // 因为TreeNode是具体的节点，添加节点操作应该由相应的树来完成
   /* public void add(TreeNode node){
    }*/

   //删除值
   /* public void delete(String val){
    *//*  如果是按照一般思维，当前节点的值需要删除，需要考虑的逻辑很多,
    比如需要找到该节点的父节点，需要找到该节点的左或者右节点，就像链表思路一样，你在删除一个节点时，
    需要考虑它的前一个与后一个，比较麻烦，还要考虑树的高度，具体的树里面有具体的实现删除方式，
    节点类里面就不写了
        if(this.val.equals(val)){
        }*//*
    }*/

    @Override
    public String toString() {
        return "TreeNode.val : "+val;
    }

}
