package 二零年8月;
/*
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
*
* 思路：根据中序遍历：左--根--右的思路， 使用dfs思想解决问题。
*
* 将 二叉搜索树 转换成一个 “排序的循环双向链表” ，其中包含三个要素：

排序链表： 节点应从小到大排序，因此应使用 中序遍历 “从小到大”访问树的节点；
双向链表： 在构建相邻节点（设前驱节点 pre ，当前节点 cur）关系时，不仅应 pre.right = cur  ，也应 cur.left = pre 。
循环链表： 设链表头节点 head 和尾节点 tail ，则应构建 head.left = taill 和 tail.right = head 。

* */
public class S36 {

    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }

        dfs(root);

        //构建循环链表
        head.left=pre;
        pre.right=head;
        return head;
    }

    void dfs(Node cur){ //按照中序
        if(cur==null){
            return;
        }
        dfs(cur.left);

        //构建双向链表
        if(pre!=null){
            pre.right=cur;
        }else {
            head=cur; //否则头结点为当前节点
        }
        cur.left=pre;
        pre=cur;

        dfs(cur.right);

    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
