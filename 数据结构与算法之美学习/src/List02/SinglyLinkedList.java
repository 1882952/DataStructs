package List02;

import java.util.LinkedList;

/*
* /**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * 总结：对于单链表的操作来说，一定要注意当前链表的前驱节点。还有就是需要先操作某节点，必须先把这个节点保存起来。
 */
public class SinglyLinkedList {
    private LinkedList linkedList=null;

    private Node head=null;

    //根据值查找节点
    public Node findByValue(int val){
        Node p=head;
        while (p!=null && p.val!=val){  //如果没有符合的，就一直往下一位找
            p=p.next;
        }
        return p;
    }
    //根据下标查找节点，那就每遍历一次节点，需要记录一次下标
    public Node findByIndex(int index){
        Node p=head;
        int pos=0; //下标
        while (p!=null && pos!=index){
            p=p.next;
            pos++;
        }
        return p;
    }

    //添加头结点（只传入值）
    public void insertToHead(int val){
        Node newNode=new Node(val,null);
        insertToHead(newNode);
    }
    //添加头结点
    public void insertToHead(Node newNode){
        if(head==null){
            head=newNode;
        }else { //如果有头结点，就更新头结点
            newNode.next=head;
            head=newNode;
        }
    }

    //顺序插入节点

    //链表尾部插入节点
    public void insertTail(int value){
        Node newNode=new Node(value,null);
        if(head==null){
            head=newNode;
        }else {
            Node q=head;
            while (q.next!=null){ //找到尾节点
                q=q.next;
            }
            newNode.next=q.next;  //更新尾节点
            q.next=newNode;
        }
    }

    //在某节点后插入一个值
    public void insertAfter(Node node,int Val){
        Node newNode=new Node(Val,null);
        insertAfter(node,newNode);
    }
    //在p节点后面插入newNode节点
    public void insertAfter(Node p,Node newNode){
        if(p==null){
            return;
        }
        newNode.next=p.next;
        p.next=newNode;
    }

    //在某个节点前插入一个值
    public void insertBefore(Node node,int val){
        Node newNode=new Node(val,null);
        insertBefore(node,newNode);
    }
    public void insertBefore(Node p,Node newNode){
        //因为是单链表，所以要在某个节点前添加一个新节点，需要查出这个节点的前一个节点
        if(p==null){
            return;
        }
        if(head==p){ //说明在头结点前插入节点
            insertToHead(newNode);
            return;
        }
        //下面是一般情况
        Node cur=head;
       while (cur!=null && cur.next!=p){ //以cur.next为判断标准
           cur=cur.next;
       }
       if(cur==null){
           return;
       }
       newNode.next=p;
       cur.next=newNode;
    }

    //删除某节点,需要找到要删除节点的前驱节点
    public void deleteByNode(Node p){
        if(p==null || head==null){
            return;
        }
        if(p==head){ //删除头结点
            head=head.next;
            return;
        }

        Node q=head;
        while (q!=null && q.next!=p){
            q=q.next;
        }
        if(q==null){
            return;
        }
        q.next=q.next.next; //感觉这里写q.next=p.next也是正确的。
    }

    //删除某值对应的节点
    public void deleteByValue(int val){
        if(head==null){
            return;
        }
        Node p=head;  //要删除的节点
        Node q=null;  //要删除节点的上一个节点
        while (p!=null && p.val!=val){
            q=p;
            p=p.next;
        }
        if(p==null){
            return;
        }
        if(q==null){ //说明p是头结点
            head=head.next;
        }else {
            q.next=q.next.next;
        }
    }
    //可重复删除某值对应的节点
    public void deleteByValueRe(int val){
        if(head==null){
            return;
        }
        if(head!=null && head.val==val){ //如果要删除的节点是首节点
            head=head.next;
        }
        Node p=head;
        while (p!=null){
            if(p.next.val==val){ //当前节点的next为要删除的节点,删除节点时，必须考虑前驱节点
                p.next=p.next.next;  //删除对应的节点
                continue;
            }
            p=p.next;
        }
    }
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
    //判断两链表是否相等
    public boolean TFResult(Node left, Node right){
        Node l=left;
        Node r=right;

        boolean flag=true;
        while (l!=null && r!=null){
            if(l.val==r.val){
                l=l.next;
                r=r.next;
                continue;
            }else {
                flag=false;
                break;
            }
        }
        return flag;
    }
    //判断是否回文，回文的做法就是利用快慢指针，然后让慢指针遍历到中间时，快指针已经到末尾。
    /*
    * 在这个过程中，可以让慢指针移动时就边移动边反转链表，或者移动完了之后，在做一个反转前半部分链表的操作，
    * 然后再让前半部分与后半部分的链表依次比较是否相等。
    *
    * 这里采用的是比较清晰化的三步，1：先快慢指针，2：然后反转后半部分链表；3：比较前半部分链表与后半部分链表
    * */
    public boolean palindrome(){
        if(head==null){
            return false;
        }else {
            Node p=head; //慢指针
            Node q=head; //快指针
            if(p.next==null){ //只有一个元素
                return true;
            }
            //快慢指针开始
            while (q.next!=null && q.next.next!=null){
                p=p.next;
                q=q.next.next;
            }
            Node leftLink = null;//左边的第一个节点
            Node rightLink = null; //右边的第一个节点
            if(q.next==null){ //说明是奇数链
                rightLink=p.next;
                leftLink=inverseLinkList(p).next; //反转前半部分链表，并删除首节点（即原来的中间节点）
            }else {
                rightLink=p.next;
                leftLink=inverseLinkList(p);
            }
            return TFResult(leftLink,rightLink);
        }
    }

    //带节点的链表反转
    public Node inverseLinkList_head(Node p){
        //head为新建的一个链表节点，这个相当于一个哨兵节点
        Node head=new Node(9999,null);
        head.next=p; //将这个哨兵节点放在首位（p为原来的链表头结点，现在换成了head指向这个链表）
         /*
        带头结点的链表翻转等价于
        从第二个元素开始重新头插法建立链表
        */
         Node cur=p.next;
         p.next=null;  //已经将p的下一个节点用cur保存了，所以将p.next置空， 这个时候就将链表分为两部分，已经反转的 和将要反转的，细细品味
         Node next=null;
         while (cur!=null){  //使用哨兵节点反转链表，理解起来就容易多了
             next=cur.next;
             cur.next=head.next;
             head.next=cur;
             cur=next;
         }
         return head.next;
    }

    //不带头节点的链表反转，那么就需要两指针，当前节点的指针cur，与当前节点的前一个节点的指针pre，用这两个指针在迭代时交换就行
    public Node inverseLinkList(Node p){ //传入的p节点代表链表反转部分的尾节点
        if(p==null || p.next==null){
            return p;
        }
        Node cur=head;
        Node prev=null;
        while (cur!=p){
            Node next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        cur.next=prev;
        return cur;
    }

    public static Node createNode(int value){
        return new Node(value, null);
    }
    public static class Node{
       private int val;
       private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }
    }
}
