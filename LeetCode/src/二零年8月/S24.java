package 二零年8月;
/*
    反转链表
* 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 思路：带头结点的链表反转 与 不带头结点的链表反转
* */
public class S24 {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode newNode=new ListNode(-1);
        newNode.next=head;

        ListNode cur=head.next;
        head.next=null;
        ListNode next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=newNode.next;
            newNode.next=cur;
            cur=next;
        }
        return newNode.next;
    }

    //不添加头结点的链表反转
    public ListNode reverseList1(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode cur=head;
        ListNode prev=null;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
