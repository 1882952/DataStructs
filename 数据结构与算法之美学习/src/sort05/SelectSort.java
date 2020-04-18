package sort05;
/*
* 选择排序：
* 与插入排序类似，都是有两个分区，一个已排序区域，一个未排序的分区
* 但是选择排序的不同点是，每次都选择待排序区域最小的元素，插入到已排序区域的最后一位末
* */
public class SelectSort {
    public static void selectSort(int[] a,int n){
        for (int i = 0; i <n-1 ; i++) {
            //查找最小值,然后与当前i交换
            int minIndex=i;
            for (int j = i+1; j <n ; j++) { //每次找出最小值的下标
                if(a[minIndex]>a[j]){
                    minIndex=j;
                }
            }
            //最后再交换
            int temp=a[i];
            a[i]=a[minIndex];
            a[minIndex]=temp;
        }
    }
}
