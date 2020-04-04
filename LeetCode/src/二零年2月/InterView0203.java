package 二零年2月;
/*
* 实现一种算法，删除单向链表中间的某个节点（除了第一个和最后一个节点，不一定是中间节点），
* 假定你只能访问该节点。
示例：
输入：单向链表a->b->c->d->e->f中的节点c
结果：不返回任何数据，但该链表变为a->b->d->e->f

* */
public class InterView0203 {
    public void deleteNode(ListNode node, int n) {
        if(node.val==n){
            node=node.next;
            return;
        }
        //利用单指针与node.next
        ListNode temp=node;
        while (temp.next!=null){
            if (temp.next.val==n){
                temp.next=temp.next.next;
                return;
            }else {
                temp=temp.next;
            }
        }
    }
    //不知道为什么，自己写的还是提交不成功，这是成功提交的代码，可能是由于空间判断出了问题
    public void deleteNode1(ListNode node, int n) {
        ListNode cur = node;
        while (cur != null) {
            if (cur.val == n) {
                cur.val = cur.next.val;
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
    }
}
