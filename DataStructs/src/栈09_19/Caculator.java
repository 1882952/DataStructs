package 栈09_19;
/*
* 利用栈实现计算器
* 数栈和符号栈
* */
public class Caculator {
    public void caculate(String s){
       char [] c= s.toCharArray();
        int i=0;//索引，用于遍历表达式
        StackUseArray2 num=new StackUseArray2(new String[20]); //数栈
        StackUseArray2 calu=new StackUseArray2(new String[10]);//值栈


    }
    public static void main(String[] args) {

    }
}

 class StackUseArray2{
    private int maxSize;//栈的大小
    private String [] stack;
    private int top=-1; //模拟栈顶

    public StackUseArray2(String[] stack) {
        this.stack = stack;
        this.maxSize=stack.length;
    }
    //判断栈满
    public boolean isFull(){
        return maxSize-1==top?true:false;
    }
    //判断栈空
    public boolean isempty(){
        return top==-1?true:false;
    }
    //向栈中添加数据
    public void push(String s){
        if(isFull()){
            System.out.println("栈已经满了，不能添加数据。。");
            return;
        }
        top++;
        stack[top]=s;
    }
    //向栈中弹出数据
    public String pop(){
        if(isempty()){
            throw new RuntimeException("栈中元素已空，不能弹出数据");
        }
        String value=stack[top];
        stack[top]=null;
        top--;
        return value;
    }
    //遍历栈中数据
    public void display(){
        int x=top;
        while (x!=-1){
            System.out.print(stack[x]+"\t");
            x--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String [] c=new String[5];
        StackUseArray stack=new StackUseArray(c);
        for (int i = 0; i <5 ; i++) {
            stack.push(i+"A");
        }
        stack.display();
        for (int i = 0; i <5 ; i++) {
            System.out.print(stack.pop()+"\t");
        }
        System.out.println();
        stack.pop();
    }
}