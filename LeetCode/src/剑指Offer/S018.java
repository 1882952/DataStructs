package 剑指Offer;


/**
 *  删除链表的节点
 *  给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 *  思路：利用双指针法， 前后两指针，记录前一个节点与当前要被删除的节点，删除后好形成一个新链表
 */
public class S018 {

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val){
            return head.next;
        }
        ListNode pre = head,cur = head.next;
        while (cur!=null && cur.val!=val){
            pre=cur;
            cur=cur.next;
        }
        if(cur!=null){
            pre.next=cur.next;
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
