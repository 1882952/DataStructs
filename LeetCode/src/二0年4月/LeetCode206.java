package 二0年4月;
/*
* 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
* */
public class LeetCode206 {

    //时间复杂度，代码块主体有一个while循环，时间复杂度为O（n），空间复杂度为O（1）
    public ListNode reverseList(ListNode head) {
        //使用迭代
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev=null; //指向当前节点的前一个节点,类似于哨兵节点
        ListNode curr=head; //指向当前节点
        //这里是需要next不为null的，因为要把当前节点和next节点每次都要交换
        while (curr!=null){
            ListNode next=curr.next; //先保存cur的next节点
            curr.next=prev; //将cur.next指向上一个节点，完成反转
            prev=curr; //当前节点设置为prev，在下一次循环时当做上一个节点
            curr=next;  //继续处理下一个节点
        }
        return prev;
    }

    //使用递归反转链表
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode  p=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return p;
    }
}
