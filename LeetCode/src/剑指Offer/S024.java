package 剑指Offer;

/**
 * 反转链表 -- 经典题目
 *
 * 思路：来个临时指针，然后遍历每一个节点，断开，插入首个节点后，再连接断开的节点就ok，详情可以画图解决。
 *  链表反转虽然简单，但是非常容易绕晕，当写这道题的时候，自己就是被绕晕了，
 *
    双指针前后关系，如果不清晰，很容易被绕晕， 说到底，链表的反转就相当于排序， 排序的本质是什么， 将已经排好的部分， 和未排序的部分做比较
    这样思考，画图，很容易就能写出来，行云流水，而且没有模糊的地方。
 */
public class S024 {
    public ListNode reverseList(ListNode head) {
        // 使用哨兵节点， 更容易实现将链表分为两部分。
        ListNode header = new ListNode(-1);
        if(head == null){
            return null;
        }
        header.next = head;
        ListNode cur = head.next;
        head.next = null; // 细品，分为两部分的关键
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = header.next;
            header.next = cur;
            cur = next;
        }

        return header.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
