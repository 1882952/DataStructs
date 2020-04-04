package 二0年4月;
/*
* 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。
* 请实现数据结构和算法来支持这些操作，也就是说：
实现 track(int x) 方法，每读入一个数字都会调用该方法；
实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
注意：本题相对原题稍作改动
示例:
输入:
["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
[[], [1], [0], [0]]
输出:
[null,0,null,1]

思路：使用二分查找树，这样就可以通过查找树当前节点左子树的大小作为题目要求的数字x的秩
* */
public class Interview1010 {
    private Node root;

    protected class Node implements Comparable<Integer>{
        int val;  //值
        int N;  //小于等于val的节点数
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.N = 1;
        }

        @Override
        public int compareTo(Integer o) {
           return this.val>o ? 1 :((this.val<o) ? -1 : 0);
        }
    }

    public Interview1010() {
    }


    //相当于put操作
    public void track(int x) {
        root=track(root,x);
    }
    //问题出在返回值中，使用非递归，node是不断变化的，所以出错，还是直接在方法中拿root引用，传参会有问题
    private Node track(Node node,int x){
        if(node==null){
            node=new Node(x);
            root=node;
        }else {
            while (node!=null){
                int cmp=node.compareTo(x);
                if(cmp==0){  //等于node节点，则让N++就行，并不需要在树中添加新的节点
                    node.N++;break;
                }else if(cmp>0){ //证明x小于当前节点，向左子树中添加，注意这是非递归实现，所以理解起来要层级理解
                    node.N++; //因为x在左子树上，需生成新节点，所以当前节点node++
                    if(node.left!=null){
                        node=node.left;
                    }else { //到这里运行就是x还是小于当前节点，且当前节点的左子节点为空，可生成新节点
                        node.left=new Node(x);
                        break;
                    }
                }else { //证明x大于当前节点，向右子树中添加
                    if(node.right!=null){
                        node=node.right;
                    }else { //同理
                        node.right=new Node(x);
                        break;
                    }
                }
            }
        }
        return root;
    }

    //类似于查找
    public int getRankOfNumber(int x) {
        return get(root,x);
    }
    public int get(Node node,int x){
        if (node==null){
            return 0;
        }
        int nums=0;
        //接下来就是找到该节点
        while (node!=null){
            int cmp=node.compareTo(x);
            if(cmp<0){ //证明x在当前节点的右子树中，所以先添加当前节点上的N
                nums+=node.N;
                node=node.right; //转到右子树
            }else if (cmp==0){  //找到了
                nums+=node.N;
                break;
            }else {
                node=node.left;  //向左子树中查找
            }
        }
        return nums;
    }
}
