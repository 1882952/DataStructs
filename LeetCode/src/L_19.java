/*
* 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
ListNode：在01中定义的
* */
public class L_19 {
    //自己的做法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0; //链表节点的个数
        int index=0; //要删除节点的位数
        int tempindex=0;
        ListNode temp=head;
        //求出链表的节点个数
        while (temp!=null){
            count++;
            temp=temp.next;
        }
        if(n>count || n<0){
            System.out.println("要删除的节点不存在");
            return head;
        }
        if(n==count){ //则证明删除头结点
            temp=head;
            head=temp.next;
        }else {
            index=count-n;  //要删除的位数，tempindex需要在循环中一步步找到删除的位数，策略是tempindex+1=index
            temp=head;
            ListNode tempnext=null;
            while (temp.next!=null){
                if((tempindex+1)==index){
                    tempnext=temp.next;
                    temp.next=tempnext.next;
                    break;
                }
                temp=temp.next;
                tempindex++;
            }

        }
        return head;
    }
    //还可以利用双指针双指针，指针A先移动n次， 指针B再开始移动。当A到达null的时候， 指针b的位置正好是倒数n
    //设想假设设定了双指针p和q的话，当q指向末尾的NULL，p与q之间相隔的元素个数为n时，那么删除掉p的下一个指针就完成了要求。
}

