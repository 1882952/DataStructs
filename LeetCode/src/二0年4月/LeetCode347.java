package 二0年4月;

import java.util.*;

/*
* 前K个高频元素
* 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:
输入: nums = [1], k = 1
输出: [1]

思路：使用hash表和小顶堆
用hashmap先记录，然后将对应的记录添加到小顶堆中，
* */
public class LeetCode347 {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count=new HashMap<>();
        for (int i: nums) {
            count.put(i,count.getOrDefault(i,0)+1);
        }
        /*
        * 定义一个优先队列，并重写compare方法,利用lambda
        * */
        PriorityQueue<Integer> heap=new PriorityQueue<>((n1,n2)->count.get(n1)-count.get(n2));
        for (int n:
             count.keySet()) {
            heap.add(n);
            if(heap.size()>k){
                heap.poll(); //弹出堆顶最小频率的
            }
        }
        List<Integer> top_K=new LinkedList<>();
        while (!heap.isEmpty()){
            top_K.add(heap.poll());
        }
        Collections.reverse(top_K);
        return top_K;
    }

    public static void main(String[] args) {
        int []a={1,1,4,5,7,1,1,4,5,4,7};
        List<Integer> temp=LeetCode347.topKFrequent(a,2);
        System.out.println(temp.toString());
    }
}
