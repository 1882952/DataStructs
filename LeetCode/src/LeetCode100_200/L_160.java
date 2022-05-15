package LeetCode100_200;

/**
 * 160. 相交链表
 *  给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *  思路： 链表指针，指向了第二个链表就算相交，  因为要返回相交的节点，所以就要使用初中的数学知识
 *        设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 *        如果a+b == b+a ,那么证明就是没有交点，返回null
 */

public class L_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA,l2=headB;
        while (l1!=l2){
            l1 = (l1==null) ? headB : l1.next;
            l2 = (l2==null) ? headA : l2.next;
        }
        return l1;
    }

    class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
