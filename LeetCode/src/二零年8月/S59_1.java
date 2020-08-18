package 二零年8月;

import java.util.Deque;
import java.util.LinkedList;

/** 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 思路 ： （1）暴力，遍历数组，找出每三个中的最大值，保存到int数组 ，但问题时重复的判断很多，会超时。
 *        （2）利用双端队列deque模拟滑动窗口，deque内仅包含窗口内的元素，deque内的元素非严格递减。
 *          算法流程：
             * 初始化： 双端队列 deque ，结果列表 res ，数组长度 n；
             * 滑动窗口： 左边界范围 i∈[1−k,n+1−k] ，右边界范围 j∈[0,n−1] ；
             * 若 i > 0 且 队首元素 deque[0] == 被删除元素 nums[i−1] ：则队首元素出队；
             * 删除 deque 内所有 <nums[j] 的元素，以保持 deque 递减；
             * 将 nums[j] 添加至 deque 尾部；
             * 若已形成窗口（即 i≥0 ）：将窗口最大值（即队首元素 deque[0] ）添加至列表 res 。
             * 返回值： 返回结果列表 res 。
 *   总之，保持每次滑动窗口改变时，deque总是保存递减元素。
 */
public class S59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k==0){
            return new int[0];
        }
        Deque<Integer> deque=new LinkedList<>();

        int []res=new int[nums.length-k+1];
        for(int j=0,i=1-k;j<nums.length;i++,j++){
            if(i>0 && deque.peekFirst()==nums[i-1]){
                deque.removeFirst(); //删除deque中对应的nums[i-1]
            }
            while (!deque.isEmpty() && deque.peekLast()<nums[j]){
                deque.removeLast(); //保持deque的递减
            }
            deque.addLast(nums[j]);
            if(i>=0){
                res[i]=deque.peekFirst(); //记录窗口的最大值
            }
        }
        return res;
    }
}
