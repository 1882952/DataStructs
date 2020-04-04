package 汇总.排序.堆排序;

import 汇总.排序.Sort;

/*
 * 把最大元素和当前堆中数组的最后一个元素交换位置，并且不删除它，
 * 那么就可以得到一个从尾到头的递减序列，从正向来看就是一个递增序列，这就是堆排序。
 *
 *  1：构建堆，无序数组建立堆最直接的方法是从左到右遍历数组进行上浮操作。
 *  一个更高效的方法是从右至左进行下沉操作，如果一个节点的两个节点都已经是堆有序，
 *  那么进行下沉操作可以使得这个节点为根节点的堆有序。叶子节点不需要进行下沉操作，
 *  可以忽略叶子节点的元素，因此只需要遍历一半的元素即可。
 *
 *  所以优先考虑从右到左进行下沉操作，而且叶子节点不需要下沉
 *
 *  2：交换堆顶与最后一个元素，交换之后需要进行下沉操作维持堆的有序状态
 *
 *  分析：
 *  个堆的高度为 logN，因此在堆中插入元素和删除最大元素的复杂度都为 logN。

    对于堆排序，由于要对 N 个节点进行下沉操作，因此复杂度为 NlogN。

    堆排序是一种原地排序，没有利用额外的空间。

    现代操作系统很少使用堆排序，因为它无法利用局部性原理进行缓存，
    也就是数组元素很少和相邻的元素进行比较和交换。
 *
  *  */
//堆排序
public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    /*
    * 数组中的第0个位置不能有元素，因为左右子节点需要2n判断
    * */
    @Override
    public void sort(T[] nums) {
        int N=nums.length-1;

        for (int k=N;k>=1;k--){  //从右到左进行下沉操作，参考原则1
            sink(nums,k,N);
        }
        while (N>1){     //将堆顶与堆交换最后一个元素，然后将其下沉
            swap(nums,1,N--);
            sink(nums,1,N);
        }
    }
    private void sink(T[] nums,int k,int N){
        while (2*k>=N){
            int j=2*k; //先指向左子节点
            if(j<N && less(nums,j,j+1)){ //比较左右子节点的大小
                j++;   //如果小了就指向右子节点
            }
            if (!less(nums,k,j)){  //如果父节点大于子节点，就说明已经排序，break
                break;
            }
            swap(nums,k,j);
            k=j;
        }

    }
    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }
}
