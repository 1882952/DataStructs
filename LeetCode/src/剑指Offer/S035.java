package 剑指Offer;

/**
 * 复杂链表的复制
 *
 *  思路1： 双向链表的复制，可以用一个Map结构保存节点， 直接复制就行，这样比较容易。
 *  思路2： 使用迭代的方式，先在每个节点的后面创建一个新的节点进行复制，只复制next，然后再复制random，最后就复制好了，最后再把复制好的节点拆出来
 *          A--B--C 复制为 A--A1--B--B1--C--C1 ， 这种思路反而要注意的点很多
 */
public class S035 {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        // 复制节点,先复制节点本身与next 判断条件 node=node.next.next，因为要复制节点，所以是下下一个节点
        for(Node node = head; node!=null; node=node.next.next){
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }

        // 然后再次遍历，复制random
        for(Node node = head;node!=null; node = node.next.next){
            Node nodeNew = node.next;
            nodeNew.random = (node.random==null)?null:node.random.next; // 注意 node.random与node.random.next的区别
        }

        // 最后再将新的Node链拆出来,因为是复制的节点，所以肯定是偶数的个数，尽可能使用node.next.next
        Node headNew = head.next;
        for(Node node =head;node!=null;node=node.next){
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next!=null)?nodeNew.next.next:null;
        }
        return headNew;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
