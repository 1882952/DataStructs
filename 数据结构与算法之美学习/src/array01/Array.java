package array01;
/*
* 自定义一个int型数组，插入，删除，按照下标随机访问。
*
* */
public class Array {

    private int []data;
    private int n;   //数组的空间
    private int count; //实际占用大小

    public Array(int n) {
        this.n = n;
        this.count=0;
        this.data=new int[n];
    }

    //按照下标访问数据
    public int find(int i){
        if(i>=0 && i<count){
            return data[i];
        }
        return -1;
    }

    //在指定位置插入元素: 注意头部插入与尾部插入的判断
    public boolean insert(int index,int val){
        if(index<0 || index>count){ //插入数据要连续
            System.out.println("位置不合法");
            return false;
        }
        if(count==n){ //说明数组的空间已满
            System.out.println("数组空间已满，无法插入");
            return false;
        }
        //位置插入,  以相应位置上的数据为起点，全部后移一位
        for (int i = count; i >index ; i--) {
            data[i]=data[i-1];
        }
        data[index]=val;
        ++count;
        return true;
    }
    //根据索引，删除数据中的元素 ,同插入元素的规则一样去考虑
    public boolean remove(int index){
        if(index<0 || index>count){
            System.out.println("删除位置不合法");
            return false;
        }
        if (count==0){
            System.out.println("数组已空，无法删除");
            return false;
        }
        for (int i=index+1;i<count;i++){ //删除是从后往前移，所以i从1开始判断
            data[i-1]=data[i];
        }
        count--;
        data[count]=-1;
        return true;
    }

    public void printAll(){
        for (int datum : data) {
            System.out.print(datum+"  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();
    }
}
