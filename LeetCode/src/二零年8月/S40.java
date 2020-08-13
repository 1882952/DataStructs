package 二零年8月;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    最小K个数
* 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]

思路：
    这是一个典型的TOP K 问题
     (1) 排序去重后截取前K个数字 时间复杂度O(logN)
     (2) 维护一个大顶堆
     (3) 用快排分好前K个数
     (4) 二叉搜索树
 */
public class S40 {
    //这里使用大顶堆
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length==0 || k==0){
            return new int[0];
        }
        Queue<Integer> heap=new PriorityQueue<>((s1,s2) -> s2-s1); //默认小顶堆，改比较器为大顶堆
        for (int num: arr) {
            if(heap.size()<k){
                heap.offer(num);
            }else if(num<heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        //返回堆中元素
       return heap.stream().mapToInt(Integer::intValue).toArray();
    }


}
