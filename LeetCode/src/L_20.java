import java.util.Arrays;
import java.util.Stack;

/*
* 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

思路：利用栈，压出弹出匹配
* */
public class L_20 {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> strings=new Stack<>();
        char[] chars=s.toCharArray();
        for (char c : chars) {
            if(c=='(' || c=='[' || c=='{'){
                strings.push(c);
            }else {
                if(strings.isEmpty()){
                    return false;
                }
                char top=strings.pop();
                if(c-top<=2 && c-top>0){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return strings.isEmpty();
    }
}
