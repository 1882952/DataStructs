package 单链表09_14;
/*
单链表测试：
* */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode n1=new HeroNode(0,"小王","王老五");
        HeroNode n2=new HeroNode(1,"小李","李四");
        HeroNode n3=new HeroNode(2,"小张","张太极");
        HeroNode n4=new HeroNode(3,"小许","许真勇");
        SingleLinkedList list=new SingleLinkedList();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.iterlist();
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", ""); //头结点,建议不动，不存放具体数据

    ////当不考虑编号顺序时，找到最后一个节点，把next域指向新节点
    public void add(HeroNode node){
        //因为头结点不能动，所以需要一个辅助节点
        HeroNode temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=node;
    }
    //显示遍历
    public void iterlist(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //辅助节点为第一个有效节点
        HeroNode temp=head.next;
        while (true){
            if(temp==null){
                break;
            }
            System.out.println(temp.toString());
            temp=temp.next;
        }
    }
    //第二种添加节点的方式（根据次序将节点插入指定的位置）注意是添加，不是插入
    public void addbyorder(HeroNode heronode){
        //通过辅助节点找到添加的位置
        //因为是单链表，所以需要找到要添加位置的前一个节点
        HeroNode temp=head;
        boolean flag=false; //添加的编号是否存在，默认为false
        while (true){  //遍历链表
            if(temp.next==null){ //说明temp已经在链表最后
                break;
            }
            if(temp.next.no>heronode.no){ //位置找到，就在temp后插入
                break;
            }else if(temp.next.no==heronode.no){//说明希望添加的编号为node的节点已经存在
                flag=true;   //说明编号存在
            }
            temp=temp.next;
        }
        //判断flag的状态
        if(flag){
            System.out.println("准备插入的编号"+heronode.no+"已经存在，不能加入");
        }else {
            //添加新的节点
            heronode.next=temp.next;
            temp.next=heronode;
        }
    }
    //根据节点的编号来修改
    public void update(HeroNode heroNode){
        //判断链表为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，定义一个辅助变量
        HeroNode temp=head.next;
        boolean flag=false;
        while (true){
            if(temp==null){
                break; //到了链表的遍历结束
            }else if(temp.no==heroNode.no){
                //找到
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.name=heroNode.name;
            temp.nickname=heroNode.nickname;
        }else {
            System.out.println("没有找到编号为"+heroNode.no+"的节点");
        }
    }
    //根据节点编号来删除节点
    public void delete(int no){
        if(head.next==null){
            System.out.println("链表为空");
        }
        //找到需要修改的节点，定义一个辅助变量
        HeroNode temp=head.next;
        boolean flag=false; //定义标志位判断该节点是否存在
        while (true){
            if(temp.next==null){  //已经遍历到链表尾部
                break;
            }else if(temp.next.no==no){//删除时需找到要删除元素的前一个节点
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(flag){
            temp.next=temp.next.next;
        }else {
            System.out.println("该节点不存在于此链表");
        }
    }
    //查找单链表的倒数第k个节点，先遍历一次，得到总长度length，然后再遍历（length-k）次就得到要查找的节点（for循环）
    //还可以利用快慢指针，先让快指针走k步，再让慢指针走，当快指针达到末尾时，慢指针就是该倒数第k个节点
    //单链表的反转
    public void reverse(HeroNode herd){
        //如果当前链表为空，或者只有一个节点，无需处理
        if(head.next==null||head.next.next==null){
            return;
        }
        //定义一个新的辅助头结点
        HeroNode reversenode=new HeroNode(0,"","");
        //遍历原链表，每遍历一个节点，将其取出，放在新链表的最前端(即新的头结点的下一位)
        HeroNode cur=head.next;
        HeroNode next=null; //指向当前节点cur的下一个节点，防止链表断掉
        while (cur!=null) { //理解（赋值号右面相当于下一个节点，赋值号左相当于当前节点的next属性）
            next=cur.next; //暂时保存当前节点的下一个节点
            cur.next=reversenode.next;//将cur的下一个节点指向新的链表的最前端
            reversenode.next=cur;   //将cur连接到新的链表上
            cur=next;  //让cur后移
        }
        head.next=reversenode.next;   //实现反转
    }

}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}
