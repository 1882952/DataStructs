package 二零年8月;

import java.util.PriorityQueue;
import java.util.Queue;

/*
* 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
* 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

例如，
[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：
void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。

* 思路：首先能想到，需要把这个数据流排序，然后取中位数即可。
*      所以就需要集合保存该数据流，但是这里可以用两个堆（一个小顶堆，一个大顶堆），各保存数据流的一半元素， 那么很容易就可以找出中位数。
*      如果数据流是奇数，那么就弹出A的堆顶， 如果是偶数，a和b栈顶元素和/2.0;
* */
public class S41 {

    Queue<Integer> a,b;

    public S41() {
        a=new PriorityQueue<>(); //小顶堆 ，存储后半部分
        b=new PriorityQueue<>((x,y) -> (y-x)); //大顶堆 ，存储前半部分
    }

    public void addNum(int num) {
        if(a.size()!=b.size()){  //即 当前长度N为奇数 ，向B添加一个元素，过程如下
            a.add(num);
            b.add(a.poll());
        }else {     // N为偶数 ，向A添加一个元素,过程如下
            b.add(num);
            a.add(b.poll());
        }
    }

    public double findMedian() {
        return a.size()!=b.size() ? a.peek() : (a.peek()+b.peek())/2.0;
    }
}
