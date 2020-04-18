package sort05;
/*
* 插入排序
*
* 插入排序，分为两个分区，已经排序的分区，与未排序的分区
*
* */
public class InsertSort {
    public static void insertSort(int[] a,int n){
        for (int i = 1; i <n ; i++) {
            int value=a[i];
            int j=i-1;   //从已排序区域的最后一位开始比较
            for (;j>=0;j--){
                if(a[j]>value){  //如果已排序分区的某个元素x大于待排序的元素，那么就让x右移一位
                    a[j+1]=a[j]; //注意，是倒序比较的，即待排序元素从已排序区域的末尾开始比较
                }else {
                    break;
                }
            }
            a[j+1]=value;  //将value插入相应位置j+1
        }
    }
}

