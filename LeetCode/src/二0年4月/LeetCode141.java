package 二0年4月;

import java.util.HashSet;
import java.util.Set;

/*
* 环形链表的检查
* 给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置
（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：true
解释：链表中有一个环，其尾部连接到第二个节点。

思路：利用快慢指针判断
* */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        //使用快慢指针,快指针每次走两步，慢指针每次走一步,如果是环，总能相遇。
        ListNode fast=head.next;
        ListNode slow=head;
        while (slow!=fast){
            if(fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }

    //第二种，利用set保存节点
    public boolean hasCycle1(ListNode head){
        //利用set保存节点，每遇到一个节点就添加，如果该节点已经添加过了，那么就证明是环
        Set<ListNode> nodeset=new HashSet<>();
        if(head==null || head.next==null){
            return false;
        }
        boolean flag=false;
        while (head!=null){
            flag=nodeset.add(head);
            if(!flag){  //如果添加失败，说明已经添加过了，证明是环
                return true;
            }
            head=head.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
