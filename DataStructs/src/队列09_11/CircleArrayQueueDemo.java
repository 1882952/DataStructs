package 队列09_11;
/*
    用环形数组模仿队列
* 每一步都需要考虑取余，就相当于加个环长度再除环
* */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class CircArrayQueue{
    private int maxSize;//表示数组最大容量
    private int front;  //队列头(指向队列第一个元素位置)
    private int reau;   //队列尾（指向队列的最后一个元素的后一个位置，希望空出一个空间作为约定）
    private int [] array;
    CircArrayQueue(int maxSize){
        this.maxSize=maxSize;
        array=new int[maxSize];
        front=0;  //指向队列头部,因为数组从0下标开始
        reau=0;   //指向队列尾部
    }
    //判断队列是否满(尾指针+1余最大容量是否等于头指针)
    public boolean isFull(){
        return (reau+1)%maxSize==front;
    }
    //判断队列是否为空
    public Boolean isEmpty(){
        return reau==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满，不能添加数据");
            return;
        }
        //直接加入数据
        array[reau]=n;
        //将real后移，这里必须考虑取模，因为环形
        reau=(reau+1)%maxSize;
    }
    //数据出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列空，不能再取");
        }
       //需要分析出front指向队列的第一个元素
        //先将front对应的元素保存在临时变量，然后将front后移
        int i=array[front];
        //front后移的时候考虑取模，因为环形
        front=(front+1)%maxSize;
        return i;
    }
    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        //思路：从front开始，遍历有效元素
        for (int i=front;i<front+getSize();i++){
            System.out.println(array[i%maxSize]);
        }
    }
    //求出多少个有效数据
    public int getSize(){
        int i=(reau+maxSize-front)%maxSize;
        return i;
    }
}
