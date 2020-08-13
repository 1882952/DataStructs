package 二零年8月;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
    字符串的排列

*输入一个字符串，打印出该字符串中字符的所有排列。

你可以以任意顺序返回这个字符串数组，
但里面不能有重复元素。

思路：数组中的全排列， 这个时候用回朔解决问题,使用dfs思路+剪枝（当字符串遇到重复的字符时）
* */

public class S38 {
    List<String> res=new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c=s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x){
        if(x==c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set=new HashSet<>();
        for (int i=x;i<c.length;i++){
            if(set.contains(c[i])){ //重复，剪枝
                continue;
            }
            set.add(c[i]);
            swap(i,x); //交换
            dfs(x+1); //开启第x+1位字符
            swap(i,x); //最后恢复交换
        }
    }

    void swap(int a,int b){
        char temp=c[a];
        c[a]=c[b];
        c[b]=temp;
    }
}
