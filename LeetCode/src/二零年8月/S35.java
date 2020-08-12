package 二零年8月;

import sun.applet.resources.MsgAppletViewer;

import java.util.HashMap;
import java.util.Map;

/*
复杂链表的复制：

* 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，

还有一个 random 指针指向链表中的任意节点或者 null。

思路 ：该题的重点在于Node中的字段random指针指向的节点的确定,准确来说，考点是深拷贝

可以采用hashMap保存所有复制的节点，然后根据原节点的关系链接新的节点。

或者可以采用dfs，Bfs，都行

* */
public class S35 {

    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Map<Node,Node> map=new HashMap<>();
        Node cur=head;
        while (cur!=null){ //复制保存各个节点
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        //然后复制节点的指向
        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }

        return map.get(head);
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
