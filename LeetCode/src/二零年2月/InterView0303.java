package 二零年2月;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
* 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，
* 我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组
* 成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该
* 与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
 * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
示例1:
 输入：
["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
[[1], [1], [2], [1], [], []]
 输出：
[null, null, null, 2, 1, -1]
示例2:
 输入：
["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
[[2], [1], [2], [3], [0], [0], [0]]
 输出：
[null, null, null, null, 2, 1, 3]

用栈集合解决问题，
这道题的意思是：每个栈只能保存cap个元素，吐槽：示例的真特么莫名其妙
* */
public class InterView0303 {

    private int cup;  //栈里保存的默认个数
    private List<Stack<Integer>> lists=new ArrayList<>();

    public InterView0303(int cap) {
        this.cup=cap;
    }

    public void push(int val) {
        if(cup<=0){ return;}
        if(lists.size()==0 || lists.get(lists.size()-1).size()==cup){
            lists.add(new Stack<>());
        }
        lists.get(lists.size()-1).push(val);
    }

    public int pop() {
        return popAt(lists.size()-1);
    }
    //弹出指定栈的栈顶元素
    public int popAt(int index) {
        if(cup<0 || lists.size()<=index || index<0){
            return -1;
        }
        int i=lists.get(index).pop();
        if(lists.get(index).isEmpty()){
            lists.remove(lists.get(index));
        }
        return i;
    }
}
