package 单向环形链表09_18;
/*
* 约瑟夫环问题
* */
public class JosepfuProblem {
    public static void main(String[] args) {
        CircleSingleLinkedList c=new CircleSingleLinkedList();
        c.addBoy(5);
        c.countBoy(2,2,5);
        //c.display();
    }
}
//环形链
class CircleSingleLinkedList{
    //创建一个first节点
    private Boy first=new Boy(-1);

    //动态添加环，思路：每次添加后都让cur指向添加的节点，也就是末尾节点，这样继续添加时就可以将新节点纳入环中
    public void addBoy(int nums){
        if(nums<1){
            System.out.println("不可添加");
            return;
        }
        Boy curBoy=null; //辅助指针
        //使用for循环创建环形链表
        for (int i=1;i<=nums;i++){
            //根据编号创建小孩节点
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first); //first指向first
                curBoy=first;  //让cur指向第一个小孩，辅助变量
                continue;
            }
            curBoy.setNext(boy);    //让cur.next指向当前节点，去环
            curBoy=curBoy.getNext();//让cur指向当前节点
            curBoy.setNext(first);  //让cur.next指向第一个节点，重新形成环
        }
    }
    //遍历
    public void display(){
        if(first.getNo()==-1){
            System.out.println("环形链表不存在");
        }
        Boy temp=first;
        while (true){
            System.out.println("当前小孩编号是："+temp.getNo());
            temp=temp.getNext();
            if(temp==first){
                break;
            }
        }
    }
    //根据用户输入计算小孩出圈的顺序(利用first指针弹出每次出圈的小孩)
    //还是利用了快慢指针，慢指针指向头，快指针指向末且快指针的next是慢指针，每次都保持这个规则就行
    public void countBoy(int startNo,int m,int nums){
        if(first==null||startNo<1||startNo>nums){
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针helpter，指向环形链的最后一个节点
        Boy helpter=first;
        while (true) {
            if (helpter.getNext() == first) {
                break;
            }
            helpter =helpter.getNext();
        }
        //小孩报数前，先让first和helpter移动startNo-1次,让first定位到startNo处（first默认从1开始）
        for(int j=0;j<startNo-1;j++){
            first=first.getNext();
            helpter=helpter.getNext();
        }
        //循环操作，直到圈中只有一个节点
        while (true){
            if(helpter==first){ //说明圈中只有一个节点
                System.out.println(helpter.getNo());
                break;
            }
            //让first，helpter同时移动m-1次
            for(int i=0;i<m-1;i++){
                first=first.getNext();
                helpter=helpter.getNext();
            }
            System.out.println(first.getNo());
            //当前first出圈操作
            first=first.getNext();
            helpter.setNext(first);
        }
    }
}

//创建一个boy类，环形链节点
class Boy{
    private int no; //编号
    private Boy next=null;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
