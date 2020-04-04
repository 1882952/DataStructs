package 逆波兰计算器09_24;

import 逆波兰计算器09_24.中缀转后缀表达式.ExchangeBehind;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //定义一个后缀表达式
        //(3+4)*5-6  => 3 4 + 5 * 6 -
        String suffixExpression="3 4 + 5 * 6 -";
        //1:先将suffixExpression放入到一个list中
        //2:将list传递给一个方法，配合栈完成计算
        List<String> l=PolandNotation.getlist(suffixExpression);
        System.out.println(l);
        int x=PolandNotation.caculate(l);
        System.out.println("运算后的结果是："+x);
        System.out.println("---------------------------------------");
        //引入完整的计算过程
        String s="1+((2+3)*4)-5";
        List<String>list= ExchangeBehind.toInfixList(s);
        list=ExchangeBehind.getListExchange(list);
        int y=PolandNotation.caculate(list);
        System.out.println("运算后的结果是："+y);
    }
    //将一个逆波兰表达式放入一个list中
    public static List<String> getlist(String s){
            //将s分割,以空格作为分割符
        String[] split=s.split(" ");
        List<String> list=new ArrayList<>();
        for (int i=0;i<split.length;i++){
            list.add(split[i]);
        }
        return list;
    }
    //逆波兰表达式的计算过程
    public static int caculate(List<String> list){
        //创建栈
        Stack<String> stack=new Stack<>();
        //遍历lis，从左到右扫描
        for (String item : list) {
            //使用正则表达式来取出数
            if(item.matches("\\d+")){ //匹配的是多位数
                stack.push(item);
            }else{ //如果是运算符
                // (1):pop出两个数，运算后再将结果压入栈中,在逆波兰中，是栈顶下的元素（num1）与栈顶元素（num2）进行计算
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res=num1+num2;
                }else if(item.equals(("-"))){
                    res=num1-num2;
                }else if(item.equals("*")){
                    res=num1*num2;
                }else if(item.equals("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException("运算符有误，不是加减乘除");
                }
                //把res结果入栈
                stack.push(res+"");
            }
        }
        int x=Integer.parseInt(stack.pop());
        return x;
    }
}
