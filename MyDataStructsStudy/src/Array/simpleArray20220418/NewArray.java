package Array.simpleArray20220418;

/**
 * 自定义一个int型数组，可以按照下标随机访问。
 */

public class NewArray {
    private int[] array;
    private int n;  //数组的空间
    private int count; // 数字实际的使用大小

    public NewArray(int n){
        this.n = n;
        if(n<0 || n==0){
            n=8; //默认设置为8位大小
        }
        array = new int[n];
    }

    //按照下标访问数据
    public int find(int i){
        if(i<0 || i>n){
            throw new RuntimeException("数据越界,拒绝访问");
        }
        if(i>count){
            throw new RuntimeException("查询越界，当前位置无值存储");
        }
        return array[i];
    }

    //在指定位置插入元素: 注意头部插入与尾部插入的判断
    public boolean insert(int index,int val){
        if(index<0 || index>count){
            throw new RuntimeException("插入位置需合法，未实现非连续性插入");
        }
        if(count==n){
            throw new RuntimeException("未实现扩容机制，后续待开发");
        }
        // 插入思路，从当前位置开始，其他元素均向右前进一格
        while (count>index){
            array[count]=array[count-1];
            index++;
        }
        array[index]=val;
        count++;
        return true;
    }

    //根据索引，删除数据中的元素 ,同插入元素的规则一样去考虑
    public boolean remove(int index){
        //判断逻辑很简陋，目前仅是为了熟悉指针的用法
        if(index<0 || index>count){
            System.out.println("删除位置不合法");
            return false;
        }
        if (count==0){
            System.out.println("数组已空，无法删除");
            return false;
        }

        //删除思路，所有其余元素向左后退一格
        while (index < count){
            array[index] = array[index+1];
            index++;
        }
        array[count-1]=0; //最后一位置空
        count--;
        return true;
    }

    //输出全部元素
    public void printAll(){
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NewArray array = new NewArray(5);
        array.printAll();

        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1,5);
        array.insert(2,6);
        array.insert(4,7);
        //array.insert(3, 11);
        array.printAll();
    }
}
