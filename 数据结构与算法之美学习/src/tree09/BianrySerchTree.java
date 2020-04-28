package tree09;
/*
* 实现一个二叉查找树
* */
public class BianrySerchTree {
    private Node tree;
    //查找节点
    public Node find(int data){
        Node p=tree;
        while (p!=null){
            if(data<p.data){
                p=p.left;
            }else if(data>p.data){
                p=p.right;
            }else {
                return p;
            }
        }
        return null;
    }
    //插入节点(无重复值的插入)
    public void insert(int data){
        if(tree==null){
            tree=new Node(data);
            return;
        }
        Node p=tree;
        while (p!=null){
            if(data>p.data){ //如果大于当前节点，就插入其右子树中
                if(p.right==null){
                    p.right=new Node(data);
                    return;
                }
                p=p.right;
            }else { //data<p.data
                if(p.left==null){
                    p.left=new Node(data);
                    return;
                }
                p=p.left;
            }
        }
    }
    //分为三种情况删除
    public void delete(int data){
        Node p=tree; //指向要删除的节点，初始化指向根节点
        Node pp=null; //pp记录p的父节点
        //找到要删除的节点
        while (p!=null && p.data!=data){
            pp=p;
            if(data>p.data){
                p=p.right;
            }else {
                p=p.left;
            }
            if(p==null){ //没有找到
                return;
            }
        }
        //要删除的有两个子节点，查找后继节点替换
        if(p.left!=null && p.right!=null){
            Node minp=p.right;
            Node minpp=p; //表示minp的父节点
            while (minp.left!=null){
                minpp=minp;
                minp=minp.left;
            }
            p.data=minp.data; //替换
            p=minp;  //删除minp ，把后继节点赋给了p，最后删除p即可。
            pp=minpp;
        }
        //删除节点仅有一个叶子节点
        Node child; //p的子节点
        if(p.left!=null){
            child=p.left;
        }else if(p.right!=null){
            child=p.right;
        }else {
            child=null;
        }
        if(pp==null){tree=child;}//删除的是根节点
        else if(pp.left==p){
            pp.left=child; //删除操作
        }else {
            pp.right=child;
        }
    }
    //找到最小节点
    public Node findMin() {
        if (tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
    //找到最大节点
    public Node findMax() {
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
