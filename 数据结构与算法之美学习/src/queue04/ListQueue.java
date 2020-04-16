package queue04;
/*
* 基于链表实现的队列
*
* 使用双指针实现，两指针指向队列的队首和队尾
* 入队时是进入队尾
* 出队时是首节点出队
* */
public class ListQueue {

    private Node head=null;
    private Node tail=null;

    //入队
    public void enque(String value){
        Node newNode=new Node(value,null);
        if(tail==null){ //尾指针为空，说明队列中没有数据
            tail=newNode;
            head=newNode;
        }else {
            tail.next=newNode;
            tail=tail.next;
        }
    }
    //出队
    public String deque(){
        if(head==null){ //说明队列为空，无法弹出
            return null;
        }
      //  Node tmp=head;
        String val=head.val;
        head=head.next;
        if(head==null){ //说明出队的是队列中的最后一个节点
            tail=null;
        }
        //tmp.next=null; //及时删除弹出的节点，也可以不用，因为弹出的节点没有了外部引用，
                       // 虽然它的next指向下一个节点，但是根据gc可达式分析来说，这个节点是可以回收的。
        return val;
    }
    private static class Node{
        private String val;
        private Node next;

        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }

        public String getVal() {
            return val;
        }
    }
}
