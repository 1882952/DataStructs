package 排序.冒泡排序09_30.归并排序10_12;

import java.util.Arrays;

//归并排序，分而治之的思路，先分解，再比较合并
public class ReviewCode {

    public static void main(String[] args) {
        int[] arr={8,4,5,7,1,3,6,2};
        int[] temp=new int[arr.length];  //归并排序需要额外的空间
        merageSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 分开
     * @param arr   源数组
     * @param left  左界限
     * @param right 右界限
     * @param temp  临时保存值的数组
     */
    public static void merageSort(int[] arr,int left,int right,int [] temp){
        //因为分治合并时需要一个中间的指针作为判断
        int mid=(left+right)/2;
        if (left<right){ //如果左指针小于右指针，则证明还没有分开成单个，可以继续递归
            merageSort(arr,left,mid,temp);  //向左递归,注意判断的节点也要包含进去，注意与快排的基准值划清思路
            merageSort(arr,mid+1,right,temp);  //向右递归
            //递归完成后返回合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     * 合并的方法 ，归并的重点
     * @param arr  源数组
     * @param left  左界限（左半部分的起点）
     * @param mid   中间的界限 ，可以用来区分两部分的位置，mid是左半部分的结尾，mid+1是右半部分的起点
     * @param right  右界限（右半部分的末尾点）
     * @param temp  临时变量，保存数据的
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;   //左指针，左半部分的起点
        int j=mid+1;  //右指针，右半部分的起点
        int t=0;  //temp的下标指针,永远指向数组末尾元素的下一位
        while (i<=mid && j<=right){  //设置i，j两指针的活动范围
            //将左右部分能排序的先排
            if(arr[i]<=arr[j]){  //如果左边i指向的元素小于右边j指向的，temp保存i指向的元素
                temp[t]=arr[i];
                i++;
                t++;
            }else {
                temp[t]=arr[j];
                j++;
                t++;
            }
        }
        //上述循环有很大概率存在，左右部分中可能还有一部分未比较的数据，所以要将其保存在temp中
        while (i<=mid || j<=right){
            if(i<=mid){
                temp[t]=arr[i];
                i++;
                t++;
            }
            if(j<=right){
                temp[t]=arr[j];
                j++;
                t++;
            }
        }
        //最后，将temp中的数据，重置到arr数组中
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }

        //综上，就是归并排序的过程，虽然有点繁琐，但是逻辑很清晰。
    }
}
