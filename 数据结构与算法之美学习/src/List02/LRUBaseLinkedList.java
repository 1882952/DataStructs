package List02;
/*
* 基于单链表LRU算法（java）
*
* 采用最近最先的保存策略， 在添加一个数据时，如果链表中存在值相应的节点，就先删除该节点，然后在链表头插入数据；
*                          如果链表中没有时，如果当前链表已满，就删除最后一个节点，在链表头插入该节点；
*                                            如果链表没满，就直接插入头结点就行。
* */
public class LRUBaseLinkedList<T> {

   /* public static SNode<T> creatNode(){ //报错，原因是静态方法只能调用静态相关的资源，不能创建非静态的对象，必须把对应的类也设置为static方法
        return new SNode<Integer>();
    }*/

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;
    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * 加入缓存，如果有该数据，就将原来的数据删除，然后在表头插入该数据
     *          如果链表已满，就删除尾节点插入该数据
     *          总之，添加数据都是从链表头插入
     * @param data
     */
    public void add(T data){
        //判断能不能找到该数据对应节点的上一个节点
        SNode pre=findPreNode(data);
        if(pre!=null){ //说明链表中存在该数据，删除后再插入
            deleteElemOptim(pre);
            intsertElemAtBegin(data);
        }else {
            if(length>=this.capacity){ //容量已满
                deleteElemAtEnd(); //删除链表的最后一个节点
            }
            intsertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode){
        SNode temp=preNode.getNext();
        preNode.setNext(temp.getNext());
        temp=null;
        length--;
    }

    /**
     * 获取查找到元素的前一个结点
     * @param data
     * @return
     */
    private SNode findPreNode(T data){
        SNode node=headNode;
        while (node.getNext()!=null){
            if(data.equals(node.getNext().getElement())){
                return node;
            }
            node=node.getNext();
        }
        return null;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void intsertElemAtBegin(T data){
        SNode next=headNode.getNext();
        headNode.setNext(new SNode(data,next));
        length++;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd(){
        SNode ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }
        //找到倒数第二个节点
        while (ptr.next.next!=null){
            ptr=ptr.getNext();
        }
        SNode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        SNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class SNode<T>{
        private T element;
        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }
        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
}
