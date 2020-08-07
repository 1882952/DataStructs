package 二零年8月;

import java.util.Stack;

/*
* 包含min函数的栈
*   定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

思路 ：采用两个栈解决问题, s1保存数字， s2保存最小的那个数字
 * */
public class S30 {

    private Stack<Integer> s1,s2;

    public S30() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void push(int x) {
        s1.add(x);
        if(s2.empty() || s2.peek()>=x){ //如果x小于s2就更新
            s2.add(x);
        }
    }

    public void pop() {
        if(s1.pop().equals(s2.peek())){
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
