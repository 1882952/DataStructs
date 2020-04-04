package 二零年2月;

import java.util.HashSet;
import java.util.Set;

/*
* 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
示例1:
 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:
 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：
链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。

* */
public class InterView10 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode temp=head;
        Set<Integer> set=new HashSet<>();
        set.add(temp.val);
        while (temp.next!=null){

            if(set.add(temp.next.val)){
                temp=temp.next;
            }else {//如果当前的节点的下一个节点的值出现过，删掉
                temp.next=temp.next.next;
            }
        }
        return head;
    }

    public ListNode removeDuplicateNodes1(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode temp=head;
        Set<Integer> set=new HashSet<>();
        set.add(head.val);
        while (temp.next!=null){
            if(!set.add(temp.next.val)){
                temp.next=temp.next.next;
            }else {
                temp=temp.next;
            }
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
