package 二零年8月;
/*
    合并两个有序链表
* 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
*
    思路：可以使用哨兵节点解决问题
*/
public class S25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            return l1!=null? l1:l2;
        }

        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode newN=new ListNode(-1);
        ListNode ntmp=newN;
        while (temp1!=null && temp2!=null){

            if(temp1.val<=temp2.val){
                ntmp.next=temp1;
                temp1=temp1.next;
            }else {
                ntmp.next=temp2;
                temp2=temp2.next;
            }
            ntmp=ntmp.next;
        }
        ntmp.next= temp1!=null ? temp1:temp2;
        return newN.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
