package skiplist07;

import java.util.Random;

/*
* 跳表的一种实现方式
* 跳表中存储的是正整数，并且存储的数据时不重复的
* */
public class SkipList {
    private static final float SKIPLIST_P = 0.5f; //跳表的分割原则，每两个点抽取一个
    private static final int MAX_LEVEL = 16;  //最大索引等级

    private int levelCount=1;
    private Node head=new Node(MAX_LEVEL); //带头链表
    private Random r=new Random();


    public Node find(int value){
        Node p=head;
        //从最大层开始查找，找到小于value的前一节点，移动到下层后再开始查找
        for (int i = levelCount-1; i >=0 ; i--) {
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p=p.forwards[i]; //找到了前一个节点 相当于执行了 第i层 p=p.next
            }
        }
        //这句相当于在第0层，即原链表层， p.next.data=value ,那么就返回p.next
        if(p.forwards[0]!=null && p.forwards[0].data==value){
            return p.forwards[0];
        }else {
            return null;
        }
    }
    /*
    * 未优化的插入
    * */
    public void insert(int value){
        //随机生成一个层数
       int level=head.forwards[0]==null ? 1:randomLevel();
       //如果随机生成的层数大于levelCount，那么就增加一层
       if(level>levelCount){
           level=++levelCount;
       }
        //创建新节点
        Node newNode=new Node(level);
        newNode.data=value;
        //表示从最大层到低层，都要有节点数据
        newNode.maxLevel=level;
        //记录要更新层的层数，表示新节点更新到哪层  update相当于prev，即待插入节点在每一层的prev节点数组
        Node[] update=new Node[level];
        for (int i = 0; i <level ; i++) {
            update[i]=head;
        }
        Node p=head;
        //然后从最大层开始查找，找到前一个节点，通过--i，再移动到下层继续查找前一个节点
        for (int i = levelCount-1; i >=0 ; i--) {
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p=p.forwards[i]; //找到了前一个节点
            }
            //levelCount会大于Level，所以加上判断
            if(level>i){
                //将每层中待插入节点的前一个节点都保存
                update[i]=p;
            }
        }
        //然后就在每层中插入该节点
        for (int i = 0; i <level ; i++) {
            newNode.forwards[i]=update[i].forwards[i]; //相当于 newNode.next=preNode.next
            update[i].forwards[i]=newNode; //相当于preNode.next=newNode;
        }
    }
    //在删除节点时，要把对应的索引节点也要删除,删除操作就很好办了，找出每层的prenode，然后pre.next=pre.next.next;
    public void delete(int value){
        Node[] update=new Node[levelCount];
        Node p=head;
        for (int i=levelCount-1;i>=0;i--){
            while (p.forwards[i]!=null && p.forwards[i].data<value){
                p=p.forwards[i];   //找到了前一个节点
            }
            update[i]=p; //保存
        }
        //然后对应删除每层中的该节点就行
        if(p.forwards[0]!=null &&  p.forwards[0].data==value){
            for (int i=levelCount-1;i>=0;--i){
                if(update[i].forwards[i]!=null && update[i].forwards[i].data==value){
                    update[i].forwards[i]=update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    /**
     * 打印每个节点数据和最大层数
     */
    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }
    /**
     * 打印所有数据
     */
    public void printAll_beautiful() {
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].data : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }

    /*
    * 随机 level 次，如果是奇数层数 +1，防止伪随机
    * 理论来讲，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
  // 因为这里每一层的晋升概率是 50%。对于每一个新插入的节点，都需要调用 randomLevel 生成一个合理的层数。
  // 该 randomLevel 方法会随机生成 1~MAX_LEVEL 之间的数，且 ：
  //        50%的概率返回 1
  //        25%的概率返回 2
  //      12.5%的概率返回 3 ...
    * */
    private int randomLevel(){
        int level=1;
        for (int i = 1; i <MAX_LEVEL ; i++) {
            if(r.nextInt()%2==1){
                level++;
            }
        }
        return level;
    }

    /**
     * 跳表的节点，每个节点记录了当前节点数据和所在层数数据
     */
    public class Node {
        private int data = -1;
        /*
        * 表示当前节点位置的下一个节点所有层的数据，从上层切换到下层，就是数组下标-1，
        * forwards[3]表示当前节点在第三层的下一个节点
        * */
        private Node forwards[] = new Node[MAX_LEVEL]; //p.forwards可以理解为p.next
        private int maxLevel = 0;
        public Node(int level) {
            forwards = new Node[level];
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList list2=new SkipList();
        list2.insert(1);
        list2.insert(2);
        list2.insert(6);
        list2.insert(7);
        list2.insert(8);
        list2.insert(3);
        list2.insert(4);
        list2.insert(5);
        list2.printAll_beautiful();
        list2.printAll();
    }
}
