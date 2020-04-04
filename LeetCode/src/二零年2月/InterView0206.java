package 二零年2月;

import javafx.beans.property.ListProperty;

/*
* 面试题 02.06. 回文链表
编写一个函数，检查输入的链表是否是回文的。
示例 1：
输入： 1->2
输出： false
示例 2：
输入： 1->2->2->1
输出： true
* */
public class InterView0206 {
    public boolean isPalindrome(ListNode head) {
        //利用快慢指针找到链表的中间节点，然后让前半部分链表反转比较就好
        //慢指针一次跳一下，快指针一次跳两下，所以在快指针到末位时，慢指针一定在链表的前半段或中间
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        //因为fast一次跳两下，所以判断是fast和fast的下一位都不能为空
        while (fast!=null && fast.next!=null){
            ListNode oldCur=slow;
            slow=slow.next;
            fast=fast.next.next;
            //每跳一次就将oldCur添加至头结点，为的是反转前半部分链表，不理解还是画图，对于链表问题，多画图是核心
            oldCur.next=prev;
            prev=oldCur;
        }
        if(fast!=null){  //说明是奇数列
            slow=slow.next;
        }
        while (prev!=null && slow!=null){
            if(prev.val!=slow.val){
                return false;
            }
            prev=prev.next;
            slow=slow.next;
        }
        return true;
    }
}
