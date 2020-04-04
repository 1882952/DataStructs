package 二零年2月;
/*
* 三合一。描述如何只用一个数组来实现三个栈。
你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，
value表示压入的值。
构造函数会传入一个stackSize参数，代表每个栈的大小。
示例1:
 输入：
["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 输出：
[null, null, null, 1, -1, -1, true]
说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
示例2:
 输入：
["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 输出：
[null, null, null, null, 2, 1, -1, -1]

思路：数组扩容三倍+3，然后就可以模拟三个栈了,原理是，比如：在第一个栈添加一个元素
则，stack[0]中（存的是栈里元素的个数，），然后利用3+第几个栈的元素个数*第几个栈+栈的元素个数+1（因为从0开始）,
就返回了添加的数组index。
* */
public class InterView0301 {
    private int [] stack;

    public InterView0301(int stackSize) {
        stack=new int[3+stackSize*3];

    }

    public void push(int stackNum, int value) {
        if(stack[stackNum]==stack.length/3-1){ //数组开头3位保存的是各个栈中元素个数的信息
            return;
        }                               //++操作是因为对应的栈中的个数统计也要加1
        stack[arrayIndex(stackNum,stack[stackNum]++)]=value;
    }

    public int pop(int stackNum) {
        if(isEmpty(stackNum)){
            return -1;
        }
        return stack[arrayIndex(stackNum,--stack[stackNum])];
    }

    public int peek(int stackNum) {
        if(isEmpty(stackNum)){
            return -1;
        }
        return stack[arrayIndex(stackNum,stack[stackNum]-1)];
    }

    public boolean isEmpty(int stackNum) {
        return stack[stackNum]==0; //判断前面三个元素是否为0
    }

    /**
     *
     * @param stacknum :第几个栈
     * @param index    :
     * @return      :返回元素在数组中位置
     */
    private int arrayIndex(int stacknum,int index){
        int stackSize=stack.length/3-1;  //先获取对应栈的大小
        return 3+stacknum*stackSize+index;
    }
}
