package 递归学习;

import java.util.Arrays;

/**
 * 归并排序
 * 采取分而置之的思想， 将一个问题划分为两个简单的子问题，然后合并处理，这个就是分治思想
 *
 * 还是一样的递归思路，然后假设  n == 1， 数组为 最小， 因为仅有单个元素
 *                          当 m== k-1 时，假设 m ， n 两个子数组已经排序完毕， 那么当n==k 时，所做的操作是将 m 与 n 的两个数组合并就行。
 */
public class MergeSort {
    public static int[] merge_sort(int[] nums){
        if(nums.length<=0){
            return new int[0];
        }
        //当n==1 时处理
        if(nums.length==1){
            return nums;
        }
        // 将数组采用分治思想，分为左右两个子数组进行处理
        int middle = nums.length/2;
        // 分数组
        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle, nums.length);
        left = merge_sort(left);
        right= merge_sort(right);

        // 合并数组
        int[] result = mergeSo(left, right);
        return result;
    }

    // 合并两数组的代码 , 将两数组排序,合并成一个数组
    private static int[] mergeSo(int[] m,int[] n){
        if(m == null){
            return new int[0];
        }
        if(n == null){
            return new int[0];
        }

        int[] res = new int[m.length+n.length];
        // 设置下标
        int mi=0,ai=0,bi=0;
        while (mi<res.length && ai< m.length && bi<n.length){
            if(m[ai]<n[bi]){
                res[mi] = m[ai];
                ai++;
            }else {
                res[mi] = n[bi];
                bi++;
            }
            mi++;
        }
        // 比较后 ， m 与 n 总会有一个数组不为空，所以，将剩余的值，直接copy给新的数组里
        if(ai<m.length){
            for (int i = ai; i <m.length ; i++) {
                res[mi++]=m[ai++];
            }
        }else if(bi<n.length) {
            for (int i = bi; i <n.length ; i++) {
                res[mi++]=n[bi++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] to_sort = {3434, 3356, 67, 12334, 878667, 387};
        int[] sorted = merge_sort(to_sort);
        for (int i = 0; i < sorted.length; i++) { System.out.println(sorted[i]); }
    }
}
