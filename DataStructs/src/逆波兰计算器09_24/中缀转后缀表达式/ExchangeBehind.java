package 逆波兰计算器09_24.中缀转后缀表达式;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
* 总结：逆波兰转换思路的重点：
*   1：优先级考虑，先考虑数，再考虑括号，最后考虑优先级。
*   2：需要两个容器，一个存运算符，括号，另一个存中间变量。由于转换规则，所以第一个用栈s1，第二个容器用集合s2模拟栈（因为保存的数据最后要逆序而且只进行压栈操作，所以就用集合来代替）
*   3：s1压左括号，遇到右括号就不断弹出并加入到s2，直到弹出左括号，将这一对丢弃就行。
*   4；因为运算符的优先级问题，当添加的符号是小于等于栈顶符号的优先级的，则栈顶元素需要弹出(因为优先级高的先运算)，这也是一个循环，
*   直到栈s1为空或者栈顶元素优先级小于该元素，将该元素加入。
*   5：最后将s1不断弹出加入到s2，就完成了转换，直接用s2就行。
*
*   后缀计算的规则：创建一个栈stack，遍历s2，如果遇到的是数字，压入stack中，如果遇到的是运算符，则弹出两元素进行计算，并将结果重新压入栈中。
*
*
* */
public class ExchangeBehind {
    public static void main(String[] args) {
        String s="1+((2+3)*4)-5";
        List<String>list=ExchangeBehind.toInfixList(s);
        list=ExchangeBehind.getListExchange(list);
        System.out.println(list);
    }
    /*
    * 思路
    * 说明：例如：1+（（2+3）*4）-5 =》 1 2 3 + 4 * + 5 -
    * 1:因为直接对一个字符串扫描不方便，先将字符串存放在容器如list中
    * */
    //将中缀表达式转为对应的list，即用list将表达式中的元素保存起来
    public static List<String> toInfixList(String s){
        List<String> list=new ArrayList<>();
        //索引，用来遍历中缀表达式字符串
        int i=0;
        String str; //对多位数进行拼接
        char c;  //每遍历到一个字符，就放入到c中
        do{
          //如果c是一个非数字，（比如括号或者运算符），需要加入list
            if((c=s.charAt(i))<48 || (c=s.charAt(i))>57){
                list.add(""+c);
                i++; //需要后移
            }else { //如果是一个数，需要考虑多位数的问题
                str=""; //先将str置空
                while (i<s.length()&&((c=s.charAt(i))>=48&&(c=s.charAt(i))<=57)){
                    str+=c; //拼接数字
                    i++;
                }
                list.add(str);
            }
        }while (i<s.length());
        return list;
    }
    //将得到的中缀表达式对应的list转为后缀表达式对应的list
    public static List<String> getListExchange(List<String> list){
        //1:定义两个栈
        Stack<String> s1=new Stack<>();//符号栈s1
        //说明，因为s2在整个转换过程中没有pop操作，而且还需要逆序输出，因此直接使用list替代栈2
        //Stack<String> s2=new Stack<>();//存储中间结果的栈s2
        List<String> s2=new ArrayList<>(); //存储中间结果的s2
        //2:遍历list
        for (String item:list){
            //3:如果是一个数入栈2
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这对括号丢弃
                while (!s1.peek().equals("(")){ //查看栈顶元素不为（
                    s2.add(s1.pop());
                }
                s1.pop();  //将这对括号的左括号弹出栈,因为右括号本来就没有压入，所以这对括号丢弃
            }else {  //考虑优先级的问题
                //当item的优先级小于等于s1的栈顶运算符，将s1的栈顶运算符弹出并加入到s2中，再次与s1中新的栈顶运算符比较
                //问题：缺少优先级比较的高低的方法，定义一个类返回比较值。
                while (s1.size()!=0 && OPeration.getValue(s1.peek())>=OPeration.getValue(item)){
                    s2.add(s1.pop());
                }
                // item优先级比栈顶高，还需要将item压入s1中,（第一次s1为空时，也直接将运算符压入）
                s1.push(item);
            }
        }
        //将s1中剩余的运算符加入到s2中
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;  //注意，因为是存放到list中，所以直接输出就是对应的后缀表达式
    }

}
