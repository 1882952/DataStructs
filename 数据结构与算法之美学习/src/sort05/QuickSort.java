package sort05;

import java.util.Arrays;

/*
* 快速排序
*
* 快速排序是利用分区点先排序，再递归到子问题，直到子问题的大小区间为1
* */
public class QuickSort {
    public void quickSout(int[] a){
        quick_c(a,0,a.length-1);
    }
    private void quick_c(int []a,int p,int r){
        if(p>=r){
            return;
        }
        //先利用分区点分区
        int q=partition(a,p,r);
        //然后再递归分成子问题分区
        quick_c(a,p,q-1);
        quick_c(a,q+1,r);
    }
    //分区的方法，并返回分区点，这里是利用了末位元素作为分区点
    private int partition(int[] a,int p,int r){
        int privot=a[r];
        int i=p;  //i为分区点位置，从当前数组头部开始
        for (int j=p;j<r;j++){
            if(a[j]<privot){  //如果当前元素小于分区点元素，那么就将该元素添加到i处，不懂了看笔记
                if(i==j){
                    i++;
                }else {
                    swap(a, i, j);
                    i++;
                }
            }
        }
        swap(a,i,r);
        return i;
    }
    private void swap(int[] a,int x,int y){
        int tmp=a[x];
        a[x]=a[y];
        a[y]=tmp;
    }

    public static void main(String[] args) {
        int[] a={7,4,8,5,1,2,4};
        QuickSort q=new QuickSort();
        q.quickSout(a);
        System.out.println(Arrays.toString(a));
    }
}
