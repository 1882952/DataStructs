package 汇总.树.二叉查找树BST;

import java.util.ArrayList;
import java.util.List;
/*
*   二叉查找树的规则是：根节点的值大于其左子节点的值，小于其右子节点的值
* 所以中序遍历可以得到一个有序递增的结果排列。
*
* 这里的实现是以key为大小判断基准的
* */
public class BST<Key extends Comparable<Key>,Value> implements OrderedST<Key,Value> {
    protected Node root;

    protected class Node{
        Key key;
        Value val;

        // 以该节点为根的子树节点总数
        int N;
        Node left;
        Node right;

        // 红黑树中使用
        boolean color;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            this.N = n;
        }
    }

    //返回该节点的N（即该节点构成的树的大小）
    private int size(Node x){
        if(x==null){
            return 0;
        }
        return x.N;
    }
    //计算某个节点的N
    protected void recalcuateSize(Node x){
        x.N=size(x.left)+size(x.right)+1;
    }

    @Override
    public int size() {
        return size(root);
    }
    //添加操作，需要注意的是添加时需要判断大小，并放到相应的位置
    //这个添加操作中有生成树的逻辑
    @Override
    public void put(Key key, Value value) {
        root=put(root,key,value);
    }
    //是递归判断添加的过程
    private Node put(Node x,Key key, Value value){
        //递归到树的最后一层，才会生成node对象，生成树
        if (x==null){
            return x=new Node(key,value,1);
        }
        //然后仍然是利用了Compareto方法进行比较判断，按照key的大小顺序组建这颗树
        int cmp=key.compareTo(x.key);
        if(cmp==0){
            x.val=value;
        }else if (cmp<0){ //应该添加到左子树
            x.left=put(x.left,key,value);
        }else {   //应该添加到右子树
            x.right=put(x.right,key,value);
        }
        //更新N的大小
        recalcuateSize(x);
        return x;
    }
    //获取节点，利用递归，查找的key与value命中后，这个命中是利用了Compareable接口比较大小的方法才能返回，否则就左右子树递归
    @Override
    public Value get(Key key) {
        return get(root,key);
    }
    private Value get(Node x, Key key){
        if (key==null){
            return null;
        }
        int cmp=key.compareTo(x.key);
        if(cmp==0){
            return x.val;
        }else if(cmp<0){  //左子树查找
            return get(x.left,key);
        }else {
            return get(x.right,key);
        }
    }
    /*
    * floor(key)：小于等于某键的最大键

    如果键小于根节点的键，那么 floor(key) 一定在左子树中；
    如果键大于根节点的键，需要先判断右子树中是否存在 floor(key)，如果存在就返回，否则根节点就是 floor(key)。
    * */
    public Key floor(Key key){
       Node x=floor(root,key);
       if(x==null){
           return null;
       }
       return x.key;
    }
    private Node floor(Node x,Key key){
        if(x==null){
            return null;
        }
       int cmp=key.compareTo(x.key);

        if(cmp==0){
           return x;
       }
       if(cmp<0){
           return floor(x.left,key);
       }

       //要么就是cmp>0,在右子树中,如果右子树中找到，返回t，否则就返回根节点x（即当前根节点就是要找的值）；
       Node t=floor(x.right,key);
        return t!=null ? t:x;
    }

    @Override
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x){
        if(x==null){
            return null;
        }
        if(x.left==null){
            return x;
        }
        return min(x.left);
    }

    @Override
    public Key max() {
        return max(root).key;
    }
    private Node max(Node x){
        if(x==null){
            return null;
        }
        if(x.right==null){
            return x;
        }
        return max(x.right);
    }

    //返回key的排名
    /* 还是递归策略，
    * 如果键和根节点的键相等，返回左子树的节点数，
       如果小于，递归计算在左子树中的排名；
       如果大于，递归计算在右子树中的排名，加上左子树的节点数，再加上 1（根节点）。
    * */
    @Override
    public int rank(Key key) {
        return rank(key,root);
    }
    private int rank(Key key,Node x){
        if(x==null){
            return 0;
        }
        int cmp=key.compareTo(x.key);
        if(cmp==0){
            return size(x.left);
        }else if(cmp<0){
           return  rank(key,x.left);
        }else {
            return 1+size(x.left)+rank(key,x.right);
        }
    }

    //删除key最小的子节点，
    public void deleteMin(){
        root=deleteMin(root);
    }
    //删除某节点上最小的节点,令指向最小节点的链接指向最小节点的右子树，这样就删除了x中的最小节点，并且返回x
    public Node deleteMin(Node x){
        if(x.left==null){ //如果x.left为空，就返回其右子树
            return x.right;
        }
        //删除，将指向最小节点的链接指向最小节点的右子树
        x.left=deleteMin(x.left);
        recalcuateSize(x);
        return x;
    }
    //删除某节点
    /*
    * 如果待删除的节点只有一个子树， 那么只需要让指向待删除节点的链接指向唯一的子树即可；
      否则，让右子树的最小节点替换该节点。 即让后继节点替换要删除的节点，  这个操作可以用上面删除该节点的最小节点完成
    * */
    public void delete(Key key){

    }
    public Node delete(Node x,Key key){
        if(x==null){
            return null;
        }
        int cmp=key.compareTo(x.key);
        if(cmp<0){
            x.left = delete(x.left, key);
        }else if (cmp>0){
            x.right=delete(x.right,key);
        }else {  //执行删除操作,分为两种情况
            //1:只有一个子节点，就直接返回（相当于把子节点挂在了待删除节点的父节点上）
            if (x.left==null){
                return x.right;
            }
            if(x.right==null){
                return x.left;
            }
            //2:有两个子节点，那么就需要找到其后继节点删除并且替换当前节点，这个时候就可以使用上面的删除某节点的最小节点的方法
            //t指针，用于备份x
            Node t=x;
            //找到当前节点上右子树中的最小节点，赋值给x
            x=min(t.right);
            x.right=deleteMin(t.right);  //删除t的右子树上的最小节点，并将删除最小节点后的t.right赋给x.right
            x.left=t.left;  //  将t.left原封不动地赋给x.left;
        }
        recalcuateSize(x);
        return x;
    }

    //利用二叉查找树中序遍历的结果为递增的特点,找到l--h之间的key的集合
    @Override
    public List<Key> keys(Key l, Key h) {
        return keys(root,l,h);
    }
    public List<Key> keys(Node x,Key l, Key h){
        List<Key> list=new ArrayList<>();
        if(x==null){
            return list;
        }
        //找到大于=l，小于=h的key
        int cmpL=l.compareTo(x.key);
        int cmpH=h.compareTo(x.key);
        if(cmpL>0){  //向左子树找，本来是 if (cmpL < 0)，觉得不对，改了，下面的cmpH<0也是如此
            list.addAll(keys(x.left,l,h));
        }
        if(cmpL<=0 && cmpH>=0){
            list.add(x.key);
        }
        if(cmpH<0){
            list.addAll(keys(x.right,l,h));
        }
        return list;
    }
}
