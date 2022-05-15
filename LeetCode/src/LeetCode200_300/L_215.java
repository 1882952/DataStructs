package LeetCode200_300;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 *
 *  思路： 1：  找TOP K 元素，用堆的概念去找；
 *        2：  使用快排思路
 */
public class L_215 {
    public int findKthLargest(int[] nums, int k) {
        //小顶堆, 保证堆的最大空间不超过k个
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : nums){
            queue.add(i);
            if(queue.size()>k){ // 保证堆内的元素小于 k
                queue.poll();
            }
        }
        return queue.peek();
    }
}
