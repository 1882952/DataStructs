package sort05;

import java.util.Arrays;

/*
* 归并排序
*根据分析，归并排序是典型的分治，先分开，再合并
* 至于原理，笔记已经记得很详细了，直接将笔记中的伪代码转换为代码即可
* */
public class MegreSort {
    public void megerSort(int [] a){
        megre_sort(a,0,a.length-1);
    }
    //
    private void megre_sort(int []a,int p,int r){
        if(p>=r){
            return;
        }
        int q=p+(r-p)/2;
        //先递归分
        megre_sort(a,p,q);
        megre_sort(a,q+1,r);

        //然后再合
        megre(a,p,q,r);
    }
    private void megre(int []a,int left,int q,int right){
        //先定义一个临时数组tmp，数组长度为a的大小
        int i=left,j=q+1,k=0;
        int[] temp=new int[right-left+1];
        while (i<=q && j<=right){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }else {
                temp[k++]=a[j++];
            }
        }
        //然后判断是否有一个子数组不为空
        int start=i,end=q; //假设左子数组不为空
        if(j<=right){  //如果右子树组不为空，那么就更改为右子树组
            start=j;
            end=right;
        }
        while (start<=end){
            //将剩下的元素添加到temp中
            temp[k++]=a[start++];
        }
        //最后将temp复制到a数组的对应位置上
        for (int l = 0; l <=right-left ; l++) {
            a[left+l]=temp[l];
        }
    }

    public static void main(String[] args) {
        MegreSort m=new MegreSort();
        int[] a={7,4,8,5,1,2,4};
        m.megerSort(a);
        System.out.println(Arrays.toString(a));
    }
}
