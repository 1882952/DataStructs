package 二零年8月;
/*
    链表中倒数第k个节点
* 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
* 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

    思路：快慢指针解决问题,快指针先移动k个节点，然后慢指针再移动，直到快指针到达链表尾部，返回慢指针
* */
public class S22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null ||  head.next==null){
            return head;
        }
        ListNode fast=head,slow=head;
        int i=0;
        while (fast!=null){
            if (i<k){
                fast=fast.next;
                i++;
            }else {
                fast=fast.next;
                slow=slow.next;
            }
        }
        return slow;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
