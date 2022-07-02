package 剑指Offer;

/**
 * 25 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 *  思路：就像是合并数组那样合并链表就行
 */
public class S025 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(-1);
        ListNode tmp = newNode;
        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                tmp.next=l1;
                l1=l1.next;
            }else {
                tmp.next=l2;
                l2=l2.next;
            }
            tmp=tmp.next;
        }
        if(l1 != null){
            tmp.next=l1;
        }
        if(l2 !=null){
            tmp.next = l2;
        }
        return newNode.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
