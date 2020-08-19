package 二零年8月;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 *队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1

 思路：首先能想到就是利用一个双端队列辅助，  定义一个max变量保存这个队列中的最大值。
      添加时：比较好办，就是将添加的元素与max比较即可。
      但是删除元素时，如果最大元素出队时，就无法知道队列中的下一个最大值。
      所以策略是： 让这个双端队列非严格递减，就可以完成要求保存相应的最大值。
 */
public class S59_2 {
    private Queue<Integer> queue;
    private Deque<Integer> help;

    public S59_2() {
        queue=new ArrayDeque<>();
        help=new ArrayDeque<>();
    }

    public int max_value() {
        if(help.isEmpty()){
            return -1;
        }
        return help.peekFirst();
    }

    //队列常规加入，辅助队列要非严格递减
    public void push_back(int value) {
        queue.offer(value);
        while (!help.isEmpty() && value>help.peekLast()){
            help.removeLast();
        }
        help.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int e=queue.remove();
        if(help.peekFirst().equals(e)){
            help.removeFirst();
        }
        return e;
    }
}
