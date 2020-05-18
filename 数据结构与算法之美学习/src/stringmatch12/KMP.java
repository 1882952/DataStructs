package src.stringmatch12;
/*
* KMP算法：核心是找出好前缀的所有后缀子串中最长的可匹配前缀子串的后缀子串，
*         这个最长可匹配后缀子串的求法使用模式串的next数组求出。
* */
public class KMP {
    /**
     * a, b分别是主串和模式串；n, m分别是主串和模式串的长度
     * @param a     主串
     * @param n     主串的长度
     * @param b     模式串
     * @param m     模式串的长度
     * @return      返回主串中匹配字符串下标的起点
     */
    public static int kmp(char []a,int n,char[] b,int m){
        int []next=getNext(b,m);
        int j=0;
        //遍历主串
        for (int i=0;i<n;i++){
            while (j>0 && a[i]!=b[j]){ //找到坏字符,对应的位置是a[i]与b[j]
                j=next[j-1]+1; //就在next数组找到对应好前缀最长可匹配前缀串末尾的位置，然后将j重新赋值就行，就可以继续比较
            }
            if(a[i]==b[j]){
                ++j;
            }
            if(j==m){ //说明找到匹配的字符串
                return i-m+1;
            }
        }
        return -1;
    }

    //求模式串中好前缀候选中的最长可匹配前缀子串next数组，使用动态规划求失效函数（next数组）
    private static int[] getNext(char[] b,int m){
        //定义next数组（失效函数）
        int[] next=new int[m];
        next[0]=-1;
        int k=-1;
        for (int i = 1; i <m ; i++) {
            while (k!=-1 && b[k+1]!=b[i]){ //当next[i-1]的下一位，b[i]与b[k]不相等时
                k=next[k];  //因为前一个的最长串的下一个字符不与最后一个相等，需要找前一个的次长串，问题就变成了求0到next(k)的最长串，
                            // 如果下个字符与最后一个不等，继续求次长串，也就是下一个next(k)，直到找到，或者完全没有
            }
            if(b[k+1]==b[i]){
                ++k;
            }
            next[i]=k; //因为b[k+1]==b[i]，前一个最长串前缀与后缀对应的的下一个字符相等，所以next[i]=k
        }
        return next;
    }
}
