package 剑指Offer;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *  输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *  思路： 用个栈轻松实现， 时间与空间复杂度皆是O（n） 。
 *      第二种方式就是递归，第归到最后一个节点，然后再返回添加。
 */
public class S006 {

    public int[] reversePrint(ListNode head) {
        //使用栈吧，方便简单
        Stack<Integer> stack = new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] result = new int[stack.size()];
        int i=0;
        while (!stack.isEmpty()){
            result[i++]=stack.pop();
        }
        return result;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
