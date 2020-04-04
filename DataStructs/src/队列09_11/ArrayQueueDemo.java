package 队列09_11;
/*
* 数组模拟队列
*
* */
public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class ArrayQueue{
    private int maxSize;//表示数组最大容量
    private int front;  //队列头(指向队列头的前一个位置)
    private int reau;   //队列尾（指向队列的最后一个数据）
    private int [] array;
    ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        array=new int[maxSize];
        front=-1;  //指向队列头部,因为数组从0下标开始，所以用front
        reau=-1;   //指向队列尾部
    }
    //判断队列是否满
    public boolean isFull(){
        return reau==maxSize-1;
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
        reau++;  //让reau后移
        array[reau]=n;
    }
    //数据出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            throw new RuntimeException("队列空，不能再取");
        }
        front++;  //    front后移
        return array[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        //遍历front到renu真正的队列数据
        for (int i=++front;i<reau;i++){
            System.out.println(array[i]);
        }
    }
}
