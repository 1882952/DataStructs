package 树.堆10_30;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        //要求数组进行升序排列，即大顶堆排序
        int[] arr={4,6,8,5,9};
        heapSort(arr);
    }
    public static void heapSort(int[]arr){
       /* System.out.println("堆排序！！");
        //测试：分步调整
        adjustHeap(arr,1,arr.length);
        System.out.println("第一次："+ Arrays.toString(arr));//预期结果：4,9,8,5,6

        adjustHeap(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));*/
       int temp=0;
       //将无序序列构建成一个堆，此处为大顶堆
        for (int i=arr.length/2-1;i>=0;i--){  //从下至上
            adjustHeap(arr,i,arr.length);  //从左至右
        }
        //将堆顶元素与末尾元素交换，将最大元素‘沉’到数组末端
        //重新调整结构，使其满足堆定义，继续交换堆顶元素和当前末尾元素，反复执行，直到数组有序
        for (int j = arr.length-1; j >0 ; j--) { //只判断交换n-1个元素
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j); //每次都是从堆顶开始，继续反复，length不断减小
        }
        System.out.println(Arrays.toString(arr));
    }
    //将一个数组（二叉树）调整为大顶堆（将以i为对应的非叶子节点，调整为大顶堆）
    //大顶堆调整策略：从左至右,从下至上
    //i:表示非叶子节点在数组中的索引，length：表示对多少个元素进行调整，length在不断地减小
    public static void adjustHeap(int[] arr,int i,int length){ //每一次的i只考虑从左至右调整
        int temp=arr[i];
        //开始调整  k=2*i+1：i的左子节点； k=k*2+1：k的左子节点
        for (int k=2*i+1;k<length;k=k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){  //说明左子节点的值小于右子节点的值
                k++; //k指向右子节点
            }
            if(arr[k]>temp){  //满足条件交换堆顶元素
                arr[i]=arr[k];
                i=k; //！！！  让i指向k，继续循环比较
            }else {
                break;
            }
        }
        arr[i]=temp;//将temp的值放到调整后的位置
    }
}
