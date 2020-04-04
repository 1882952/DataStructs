package 十大常用算法.kmp算法11_16;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1="BBBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABD";
        int[] next=kmpNext("AA"); //[0,1]  若为“AAA”,则next为[0,1,2]   ,如果是"AAAB" ,则next={0,1,2,0}
        System.out.println(Arrays.toString(next));

        int index=kmpSearch(str1,str2,kmpNext(str2));
        System.out.println(index);
    }
    //kmp搜索算法. str1;源串， str2；子串,  next:子串对应的部分匹配表,  返回第一个匹配的位置
    public static int kmpSearch(String str1,String str2,int[] next){
        //遍历
        for (int i = 0,j=0; i <str1.length() ; i++) {
            //需要处理str1.charAt(i)!=str2.charAt(j)的情况，去调整j的大小
            //kmp核心
            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if(str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if(j==str2.length()){  //找到了
                return i-(j-1);
            }
        }
        return -1;
    }
    //获取到一个字符串（子串）的部分匹配值  ,next存储的就是部分匹配值的规律,next的每一位值就是字符串对应部分长度的共有元素长度
    public static int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
        int[] next=new int[dest.length()];
        next[0]=0; //如果字符串dest的长度为1，部分匹配值就是0

        for (int i = 1,j=0; i <dest.length() ; i++) {  //i就是字符串的部分指针，  j就是部分匹配值的长度
            //当dest.charAt(i)!=dest.charAt(j) 时，需要从next[j-1]中获取新的j
            //直到发现dest.charAt(i)==dest.charAt(j)时才退出  ,这是kmp的核心点
            while (j>0 && dest.charAt(i)!=dest.charAt(j)){
                j=next[j-1];     //回朔,从部分匹配表中更新j
            }
            //当dest.charAt(i)==dest.charAt(j)满足时，部分匹配值就+1,比如AA的情况 next={0,1}
            if(dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
