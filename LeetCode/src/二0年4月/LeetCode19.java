package 二0年4月;
/*
* 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？

思路;利用双指针，快指针先移动n次，然后慢指针再移动，当快指针到末尾时，慢指针刚好到要删除的点.
既然要删除节点，那么就要找到要删除节点的前驱节点，那就让快指针多移动1次，为n+1次，这样慢指针就可以
少移动一次，最后指向要删除节点的前驱节点
利用一个哨兵节点pre,利用哨兵节点去做一个边界判断，这样在写链表时会轻松许多并减少bug。
* */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev=new ListNode(0);
        prev.next=head;

        ListNode fast=prev;
        ListNode slow=prev;

        //先让快指针走n+1次
        for (int i=1;i<=n+1;i++){
            fast=fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast= fast.next;
        }
        slow.next=slow.next.next;
        return prev.next;
    }
}
