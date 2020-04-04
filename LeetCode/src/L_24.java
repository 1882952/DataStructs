/*
* 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:
给定 1->2->3->4, 你应该返回 2->1->4->3.

思路：
别想太多，还是整的双指针，循环每次跳两个就行
设置一个dummy 节点简化操作,dummy next 指向head。
        初始化first为第一个节点
        初始化second为第二个节点
        初始化current为dummy
        first.next = second.next
        second.next = first
        current.next = second
        current 移动两格
        重复
* */
public class L_24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode current=dummy;
        ListNode first=null;
        ListNode second=null;
        while (current.next!=null && current.next.next!=null){
            //利用双指针
            first=current.next;
            second=current.next.next;

            //交换相邻两节点
            first.next=second.next;
            second.next=first;
            current.next=second;

            current=current.next.next;
        }
        return dummy.next;
    }
}
