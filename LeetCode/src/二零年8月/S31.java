package 二零年8月;

import java.util.Stack;

/*
* 栈的压入，弹出序列
*
* 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
* 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

    * 思路：考虑使用一个辅助栈，模拟压入/弹出的情况，然后判断即可。
    *
    * 入栈操作： 按照压栈序列的顺序执行。
      出栈操作： 每次入栈后，循环判断 “栈顶元素 == 弹出序列的当前元素” 是否成立，将符合弹出序列顺序的栈顶元素全部弹出。

* */
public class S31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int i=0;
        for(int num : pushed){
            stack.push(num);
            while (!stack.isEmpty()&& stack.peek()==popped[i]){ //循环判断栈顶元素
                stack.pop();
                i++; //如果栈顶元素与弹出数组中的当前i元素相等，弹出栈顶元素，并进行下一位判断
            }
        }
        return stack.isEmpty();
    }
}
