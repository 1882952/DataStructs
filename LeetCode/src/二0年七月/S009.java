package 二0年七月;

import java.util.Stack;

/*
* 用两个栈实现队列
* */
public class S009 {
     private Stack<Integer> s1;
     private Stack<Integer> s2;
    public S009() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void appendTail(int value) {
        while (!s2.isEmpty()){
            int i=s2.pop();
            s1.push(i);
        }
        s1.push(value);
    }

    public int deleteHead() {
        while (!s1.isEmpty()){
            int i=s1.pop();
            s2.push(i);
        }
        int re=-1;
        if(!s2.isEmpty()){
            re=s2.pop();
        }
        return re;
    }
}
