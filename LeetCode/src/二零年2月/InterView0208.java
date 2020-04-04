package 二零年2月;
/*
* 给定一个有环链表，实现一个算法返回环路的开头节点。
有环链表的定义：在链表中某个节点的next元素指向在它前面出现过的节点，则表明该链表存在环路。
示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。

思路总结;
就好像两个运动员绕环形跑道，一个速度快，一个慢，如果是环形，肯定会再次相遇，

然后就是判断环入口检查，本质上是速率和路径问题，在相遇时，fast走的路径肯定是slow的2倍，所以
利用这个就可以求出关系式L=c-x,  L ;链表头到环形链的入口，x：相遇时从环形头到相遇节点的距离，c;环形一圈的距离
* */
public class InterView0208 {
    public ListNode detectCycle(ListNode head) {
        //利用快慢指针解决环形问题，先快慢指针运行找到相遇点，然后利用路径关系做文章，找到入口点
        ListNode slow=head,fast=head;
        while (fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){  //如果是环形链表，总会有相等的时刻，因为n与2n是倍数关系，总会相遇
                break;
            }
        }
        if(fast==null || fast.next==null){ //说明不是环形链表
            return null;
        }
        // 慢指针从头开始, 快慢指针再一次相遇就是在环的起点
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }
}
