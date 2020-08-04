package 二零年8月;
/*
    删除链表的节点
* 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。

*/
public class S18 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode temp=head;
        if(head.val==val){
            head=head.next;
            return head;
        }
        while (temp!=null && temp.next!=null){
            if(temp.next.val==val){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }



    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
