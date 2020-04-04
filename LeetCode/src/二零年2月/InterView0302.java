package 二零年2月;

import java.util.Stack;

/*
* 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
* 执行push、pop和min操作的时间复杂度必须为O(1)。
示例：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

思路分析：双栈法，利用一个副栈维护最小值，每次遇到主栈压的是新的最小值就压入
还有一种方法时单栈，动态更新min
* */
public class InterView0302 {

    private Stack<Integer> mainStack;
    private Stack<Integer> helpStack;

    public InterView0302() {
        mainStack=new Stack<>();
        helpStack=new Stack<>();
    }

    public void push(int x) {
        if (mainStack.empty()){
            helpStack.push(x);
        }

        if(x<=helpStack.peek()){
            helpStack.push(x);
        }
        mainStack.push(x);

    }

    public void pop() {
        //如果主栈弹出的是最小值，那么副栈也要弹出
        Integer main=mainStack.pop();
        if(main.equals(helpStack.peek())){
            helpStack.pop();
        }
    }

    public int top() {
       return mainStack.peek();
    }

    public int getMin() {
        return helpStack.peek();
    }

    public static void main(String[] args) {
        InterView0302 obj=new InterView0302();
        obj.push(1);
        obj.push(3);
        obj.push(0);
        obj.pop();
        System.out.println(obj.getMin());
    }
}
