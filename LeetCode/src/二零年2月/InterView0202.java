package 二零年2月;
/*
* 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
注意：本题相对原题稍作改动
示例：
输入： 1->2->3->4->5 和 k = 2
输出： 4
说明：
给定的 n 保证是有效的。
* */
public class InterView0202 {
    public int kthToLast(ListNode head, int k) {
        if(head.next==null){
            return head.val;
        }
        ListNode fast=head;
        ListNode slow=head;
        //利用两个指针，快慢指针，快的先走k步，然后慢的走，当快的达到末位时，慢的刚好到达k位
        while (fast!=null){
            fast=fast.next;
            if(k==0){
                slow=slow.next;
            }else {
                k--;
            }
        }
        return slow.val;
    }
    int post=0;
    //利用递归
    public int kthToLast1(ListNode head, int k){
        if(head==null){
            return 0;
        }
        int ref=kthToLast1(head.next,k);
        post++;
        if(post==k){
            return head.val;
        }
        return ref;
    }

}
