package queue04;
/*
* 循环队列，使用数组实现
*
* 循环队列如何是实现？ 关键点在于head与tail指针的关系
* (tail+1)%n=head，那么就证明循环队列已满
*
* 注意：head指针指的是队列的首元素，tail指针是队尾元素的下一位（循环队列必须这样设计，否则无法判断循环）
* 每次添加与弹出时都是动态的位置，即 出队时head=(head+1)%n
* */
public class CircleQueue {
    private String [] items;
    private int n;  //数组大小

    private int head=0;
    private int tail=0;

    CircleQueue(int capcacity){
        items=new String[capcacity];
        this.n=capcacity;
    }

    //入队列
    public void push(String str){
        if((tail+1)%n==head){ //说明队列已经满了，无法添加
            System.out.println("队列已满，无法添加");
            return;
        }
        items[tail]=str;
        tail=(tail+1)%n;
    }
    //出队列
    public String pop(){
        if(tail==head){ //说明队列已经空了
            System.out.println("队列已空");
            return null;
        }
        String re= items[head];
        head=(head+1)%n;
        return re;
    }
    //打印循环队列
    public void printAll(){
        if(0==n){
            return;
        }
        for (int i = head; i%n !=tail ; i=(i+1)%n) {
            System.out.print(items+"  ");
        }
        System.out.println();
    }
}
