package 排序.冒泡排序09_30.归并排序10_12;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];  //归并排序需要额外的空间
        merageSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    //分+合的方法：
    public static void merageSort(int[] arr,int left,int right,int[] temp){
        if (left<right){  //递归头条件
            int mid=(left+right)/2;//中间索引
            //向左递归分解
            merageSort(arr,left,mid,temp);
            //向右递归分解
            merageSort(arr,mid+1,right,temp);
            //直到分解为单个数时，才会合并
            //到合并时
            merage(arr,left,mid,right,temp);
        }
    }
    //合并的方法
    /*
    * int[] arr:待排序的数组
    * ,int left,：左边有序序列的初始索引
    * int mid,中间索引
    * int right,右边索引
    * int[] temp：做中转的数组
    * */
    public static void merage(int[] arr,int left,int mid,int right,int[] temp){
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        int i=left; //初始化i，左边有序序列的初始索引
        int j=mid+1; //初始化j，右边有序序列的初始索引
        int t=0;  //指向temp数组的当前索引
        //第一步：先把左右两边的数组按规则填充到temp数组，直到左右两边有序序列有一边处理完毕
        while (i<=mid&&j<=right){
            if(arr[i]<=arr[j]){ //如果左边有序序列的当前元素小于等于右边的当前元素
                temp[t]=arr[i];
                t+=1;
                i+=1;
            }else {  //反之，将右边的当前元素拷贝到temp中
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }
        //第二步：将剩余数据一边的数据全部填充到temp中
        while (i<=mid){ //说明左边的序列还有剩余的
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }
        while (j<=right){ //说明右边的序列还有剩余的
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }
        //第三步：将temp中的元素拷贝到原数组
        //注意，并不是每次都拷贝所有，模拟：第一层合并：templeft=0;，right=1;|| templeft=2,right=3;
                                        //第二层合并：templeft=0，right=3；第三层合并：templeft=0，right=7；
        t=0;
        int tempLeft=left;
        System.out.println("每一次合并的templeft:"+tempLeft+";"+right);
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
    }
}
