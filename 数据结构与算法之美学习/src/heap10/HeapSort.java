package heap10;
/*
* 堆排序
* 分两步骤：建堆：采用的是数组从后往前的数据扫描方式，即从上而下堆化（下沉）
*           排序：删除堆顶元素，然后将删除的元素插入到当前有效数组中的最后一位,也是用的下沉堆化方式
* */
public class HeapSort {
    public static void sort(int[] arr){
        if(arr.length<=1){
            return;
        }
        //1:建堆
        buildHeap(arr);
        //2:排序
        int k=arr.length-1;
        while (k>0){
            swap(arr,0,k); //先将最大元素交换到数组的末尾
            hepify(arr,--k,0); //然后调整堆
        }
    }
    //建堆的方法,从后往前扫描（从最后一个非叶子节点开始）
    private static void buildHeap(int []arr){
        for (int i = (arr.length-1)/2; i >=0 ; i--) {
            hepify(arr,arr.length-1,i);
        }
    }
    /*
    * 堆化的方法，自上而下的扫描方式（下沉）
    * */
    private static void hepify(int []arr,int n,int i){
        while (true){
            int maxPos=i;
            if((2*i+1)<=n && arr[i]<arr[2*i+1]){
                maxPos=2*i+1;
            }
            if((2*i+2)<=n && arr[maxPos]<arr[2*i+2]){
                maxPos=2*i+2;
            }
            if(maxPos==i){
                break;
            }
            swap(arr,i,maxPos);
            i=maxPos;
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
