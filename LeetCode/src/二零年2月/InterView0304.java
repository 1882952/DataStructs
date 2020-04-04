package 二零年2月;

import java.util.ArrayList;
import java.util.List;

/*
* 实现一个MyQueue类，该类用两个栈来实现一个队列。

示例：
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false

说明：
你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

* */
public class InterView0304{
    private List<Integer> stack1;
    /** Initialize your data structure here. */
    public InterView0304() {
        stack1=new ArrayList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack1.size()!=0){
            return stack1.remove(0);
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if(stack1.size()!=0){
            return stack1.get(0);
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() ? true:false;
    }
}
