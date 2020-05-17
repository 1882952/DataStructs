package 二零年五月;
/*
* 输入两个链表，找出它们的第一个公共节点。
*
* 思路：使用双指针法，两指针相遇即得到交点，重点在于，当一指针遍历到末尾时，重新定位到另一个链表的头结点
* 原理：假设链表A长度是m，链表B是n，公共部分是b，那么走过m+n+b步之后一定会相遇，返回结果。 如果没有公共部分，b=0，
* 那么走过m+n都指向None，返回None
* */
public class View52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //定义双指针
        ListNode node1=headA,node2=headB;
        while (node1!=node2){
            node1=node1!=null? node1.next:headB;
            node2=node2!=null? node2.next:headA;
        }
        return node1;
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
