package 二零年2月;
/*
* 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的 节点之前。
* 如果链表中包含 x，x 只需出现在小于 x 的元素之前(如下所示)。分割元素 x 只需处于“右半部分”即可，
* 其不需要被置于左右两部分之间。
示例:
输入: head = 3->5->8->5->10->2->1, x = 5
输出: 3->1->2->10->5->5->8
* */
public class InterView0204 {
    //此题本质是考察如何进行链表头部的动态变换
    public ListNode partition(ListNode head, int x) {
        //解题思路，遍历链表，将小于x的节点至于头部，利用双指针
        if(head==null){
            return head;
        }
        ListNode t1=head.next,t2=head,temp=null;
        while (t1!=null){
            if(t1.val<x){ //将其置于头结点,画个图理解很清晰，只要保证t1一直是t2的next，即头结点（是变换的）的next
                temp=t1.next;
                t1.next=head; //将当前节点置于头部
                t2.next=temp; //设置原头部的next
                head=t1;  //重新指定头结点
                t1=temp;   //重新设置t1，因为t1一直是t2的next
            }else {
                t1=t1.next;
                t2=t2.next;
            }
        }
        return head;
    }
}
