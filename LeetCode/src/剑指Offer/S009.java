package 剑指Offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *  注意点，这道题乍看简单，但是是考察自己对栈与队列的理解，两个栈实现队列，最简单的思路就是一个栈完全保持入队列的顺序，一个栈完全保存
 *  出队列的顺序， 这样就比较清晰明了，也不用考虑过多的情况，如果即考虑入栈又考虑出栈，会有多种情况出现，反而会有问题。
 */
public class S009 {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public S009() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * 压栈
     *  先压入s1，为了保证先进先出，s1保证压入顺序， s2保证弹出顺序
     *  压入的时候，将所有元素都要放在s1中
     * @param value
     */
    public void appendTail(int value) {
        //先将s2中的元素压入s1中，保证入栈队列的顺序
        while (!stack2.isEmpty()){
           Integer pop = stack2.pop();
           stack1.push(pop);
       }
        stack1.push(value);
    }

    public int deleteHead() {
        // 弹出的时候，每次也将s1中的元素全部弹到s2中，保证出栈的顺序
        while (!stack1.isEmpty()){
            Integer pop = stack1.pop();
            stack2.push(pop);
        }
        if(stack2.isEmpty()){
            return -1;
        }
        return stack2.pop();
    }
}
