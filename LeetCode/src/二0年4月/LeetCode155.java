package 二0年4月;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
* 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

思路；定义一个变量，保存最小值就行。
* */
public class LeetCode155 {
    private Stack<Integer> stack;
    private int min=Integer.MAX_VALUE;
    public LeetCode155() {
        stack=new Stack<>();
    }

    public void push(int x) {
      if(x<=min){
          stack.push(min);
          min=x;
      }
      stack.push(x);
    }

    public void pop() {
        if (stack.pop()==min) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
