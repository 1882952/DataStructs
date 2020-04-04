package 二零年2月;

import java.util.Stack;

/*
* 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
* 但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。
* 当栈为空时，peek 返回 -1。
示例1:
 输入：
["SortedStack", "push", "push", "peek", "pop", "peek"]
[[], [1], [2], [], [], []]
 输出：
[null,null,null,1,null,2]
示例2:
 输入：
["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
[[], [], [], [1], [], []]
 输出：
[null,null,null,null,null,true]
说明:
栈中的元素数目在[0, 5000]范围内。

    思路：利用两个栈，向主栈压入数据，每当压入元素比栈顶大时，就不断循环弹出栈顶元素，然后压入到辅助
栈中，直到循环条件不成立跳出，压入当前元素，最后把辅助栈中的所有元素弹出并压入到主栈中。

   //注意：这道题用peek方法提交会报错，所以用lastElement()方法
* */
public class Interview0305 {
    //主栈
    private Stack<Integer> stack;
    private Stack<Integer> temp;
    public Interview0305() {
        stack=new Stack<>();
        temp=new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
        }else {  //每次当压入的val大于stack的栈顶元素，就需要处理,将栈顶弹出并保存在temp中,循环
            while (!stack.empty() && stack.lastElement()<=val){
                temp.push(stack.lastElement());
                stack.pop();
            }
            stack.push(val);
            //将temp中的元素重新压入主栈中
            while (!temp.empty()){
                stack.push(temp.lastElement());
                temp.pop();
            }
        }
    }

    public void pop() {
        stack.pop();
    }

    public int peek() {
        return stack.empty()?-1:stack.lastElement();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
