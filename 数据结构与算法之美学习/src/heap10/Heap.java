package heap10;
/*
* 堆的插入与删除操作
* 数组从1开始保存数据
* */
public class Heap {
    private int[] arr; //存储的数组
    private int n;  //最大容量
    private int count; //堆中已经存储的数据个数
    public Heap(int capacity){
        arr=new int[capacity+1];
        n=capacity;
        count=0;
    }
    //在数组末尾插入数据，策略：上浮(自下往上堆化)
    public void insert(int data){
        if(count>=n){return;}
        ++count;
        arr[count]=data;
        int i=count;
        while ((i/2>0) && (arr[i]>arr[i/2])){
            swap(arr,i,i/2);
            i=i/2;
        }
    }
    //删除堆顶数据,思路，将末尾元素添加到堆首，然后下沉（自上而下堆化）
    public int removeMax(){
        if(count==0){
            return -1;
        }
        int emp=arr[1];
        arr[1]=arr[count];
        count--;
        hepify(arr,count,1);
        return emp;
    }
    //下沉堆化的方法
    public void hepify(int[] a,int n,int i){
        while (true){
            // 最大值位置
            int maxPos=i;
            if(i*2<=n && a[i]<a[i*2]){ //小于左子节点
                maxPos=i*2;
            }
            if((i*2+1)<=n && a[maxPos]<a[i*2+1]){ //左边的子节点小于右子节点
                maxPos=i*2+1;
            }
            if(maxPos==i){ //如果不符合上两种情况，则最大值是当前位置，break
                break;
            }
            swap(a,i,maxPos);
            i=maxPos;
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
