package LeetCode1_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * 思路：使用一个数据结构，保存这个括号的关系,然后使用双指针做比较,建议使用map , 此方法不对
 *      正确思路:得使用一个栈，压入左边的，遇到右边的就与栈顶的做匹配，匹配就弹出，不匹配就false，就是这样，最后看栈中的元素是不是空的，
 *    是的话就是匹配的、
 */
public class L_20 {
    public boolean isValid(String s) {

        if(s.length()%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]=='(' || chars[i]=='[' || chars[i]=='{'){
                stack.push(chars[i]);
            }else {
                if(stack.isEmpty()){ // 在循环过程中，栈为空，肯定有多余出来的非匹配括号
                    return false;
                }
                char c = stack.pop();
                if(chars[i]-c <=2 && chars[i]-c>0){ // 只有括号的ASCII码间距在2之间， 此处也可以使用一个Map判断
                    continue;
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
