/*
* 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的
* ，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

* */
public class leetcode_01 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newnode=new ListNode(0);
        ListNode temp0=newnode;
        ListNode temp1=l1;
        ListNode temp2=l2;
        int curr=0;//保留每一位溢出的值
        while(temp1!=null||temp2!=null||curr!=0) {
            int x = (temp1 != null) ? temp1.val : 0;
            int y = (temp2 != null) ? temp2.val : 0;
            int sum=curr+x+y;   //x,y与溢出值的和
            curr=sum/10;
            temp0.next=new ListNode(sum%10);
            temp0=temp0.next;
            if(temp1!=null){temp1=temp1.next;}
            if(temp2!=null){temp2=temp2.next;}
        }
        if(curr>0){
            temp0.next=new ListNode(curr);
        }
        return newnode.next;
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode newnode=new ListNode(0);
        int sum=0; //每一位的和
        ListNode p1=l1,p2=l2;
        ListNode cur=newnode;
        while (p1!=null || p2!=null){
            if(p1.next!=null){
                sum+=p1.val;
                p1=p1.next;
            }
            if(p2.next!=null){
                sum+=p2.val;
                p2=p2.next;
            }
            cur.next=new ListNode(sum%10);
            sum/=10;
            cur=cur.next;
        }
        if(sum>0){
            cur.next=new ListNode(sum);
        }
        return cur;
    }
}

 class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
