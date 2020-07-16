package 二0年七月;

import java.util.ArrayList;
import java.util.List;

/*
* 从头到尾打印链表
*
* 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
*
* 思路：<1 可以使用栈压入链表节点，然后弹出后加入数组中；
*      <2 反转链表，然后顺序打印保存进数组；
*      <3 使用递归;
*
* 其中一三种方法比较简便与好做，由于对于递归不熟悉，所以这里使用递归
* */
public class S006 {

    List<Integer> tmp=new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res=new int[tmp.size()];
        for (int i = 0; i <tmp.size() ; i++) {
            res[i]=tmp.get(i);
        }
        return res;
    }

    void recur(ListNode node){
        if(node==null){
            return;
        }
        recur(node.next);
        tmp.add(node.val);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
