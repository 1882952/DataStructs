package 十大常用算法.kmp算法11_16;

public class Violencematch {
    public static void main(String[] args) {
        String str1="abcbcdcbd";
        String str2="cbc";
        int index=match(str1,str2);
        System.out.println("index"+index);
    }
    //暴力匹配算法 ,返回str1d的匹配头
    public static int match(String str1,String str2){
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        int s1Len=s1.length;
        int s2Len=s2.length;

        int i=0; //i索引指向s1
        int j=0; //j索引指向s2
        while (i<s1Len && j<s2Len){
                if (s1[i] == s2[j]) {  //匹配成功，则比较下一位
                    i++;
                    j++;
                }else {  //没有匹配成功，则回朔，i指向匹配头的下一位，即i-(j-1)  ,j从头开始匹配
                    i=i-(j-1);
                    j=0;
                }
            }
            if(j==s2Len){
                return i-j;
            }else {
                return -1;
            }
    }
}
