package 二零年2月;
/*
* 给定两个用链表表示的整数，每个节点包含一个数位。
这些数位是反向存放的，也就是个位排在链表首部。
编写函数对这两个整数求和，并用链表形式返回结果。

示例：
输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
输出：2 -> 1 -> 9，即912

进阶：假设这些数位是正向存放的，请再做一遍。
示例：
输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
输出：9 -> 1 -> 2，即912

* */
public class InterView0205 {

    //思路;老老实实按位加，注意进位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(0);
        ListNode p1=l1,p2=l2,curNode=node;
        int carry=0;  //进位的值
        while (p1!=null || p2!=null){ //从当前位判断
            int x=(p1!=null ? p1.val : 0);
            int y=(p2!=null ? p2.val : 0);
            int sum=x+y+carry;
            carry=sum/10; //重新设置进位值
            curNode.next=new ListNode(sum%10);  //获取相加的值，并保存在新链表的下一个节点，因为新链表头结点值为0，而且这样保证了有值才创建节点
            curNode=curNode.next;  //指向新链表的下一个节点
            if (p1!=null){
                p1=p1.next;
            }
            if(p2!=null){
                p2=p2.next;
            }
        }
        if(carry>0){ //最后一位有进位
            curNode.next=new ListNode(carry);
        }
        return node.next;
    }
}
