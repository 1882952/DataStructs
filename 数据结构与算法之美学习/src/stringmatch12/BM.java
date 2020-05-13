package src.stringmatch12;

import javax.swing.table.TableRowSorter;

/*
* 字符串匹配之bm算法：
*
* */
public class BM {

    public static final int SIZE=256; //全局变量或者成员变量

    /**
     * 坏字符规则，将模式串中的每个字符及其下标都存到散列表中, 散列数组中，下标为对应的全局变量SIZE充当的ASCI码，value为该字符最后一次出现的位置
     * @param b  模式串
     * @param m  模式串长度
     * @param bc 模式串散列表（数组）
     */
    private void generateBC(char[] b,int m,int[] bc){
        for (int i = 0; i <SIZE ; i++) {
            bc[i]=-1; //初始化bc
        }
        for (int i = 0; i <m ; i++) {
            int asccii=(int) b[i]; // 计算b[i]的ASCII值
            bc[asccii]=i;
        }
    }

    /**
     * bm 算法框架
     * @param a 主串
     * @param n  主串的长度
     * @param b 子串
     * @param m  子串的长度
     * @return
     */
    public int bm(char[] a, int n, char[] b, int m){
        int[] bc = new int[SIZE]; // 记录模式串中每个字符最后出现的位置
        generateBC(b,m,bc); //构建坏字符hash表
        int i = 0; // i表示主串与模式串对齐的第一个字符
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        while (i<= n-m){
            int j;

            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i+j] != b[j]) break; // 坏字符对应模式串中的下标是j
            }

            if (j<0){
                return i; //匹配成功，返回主串与模式串的第一个匹配字符的位置
            }
            // 这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位 ,模式串滑动j-x位，相当于i更新为i+j-x位。 x=bc[a[j+j]]
            //坏字符匹配：i = i + (j - bc[(int)a[i+j]]); 加上好后缀后要修改i
            int x=j - bc[(int)a[i+j]];
            int y=0;
            if(j<m-1){ //如果有好后缀的时候
                y=moveByGS(j,m,suffix,prefix); //返回好后缀中与模式串前缀匹配的首字符
            }
            i=i+Math.max(x,y);   //找到要滑动到的位置
        }
        return -1;
    }

    // 好后缀的匹配方式，j表示坏字符对应的模式串中的字符下标; m表示模式串长度
    private int moveByGS(int j,int m,int[] suffix,boolean[] prefix){
        for (int i = 0; i <m ; i++) {
            suffix[i]=-1;
            prefix[i]=false;
        }
        int k=m-1-j; //好后缀的长度
        if (suffix[k]!=-1) return j-suffix[k]+1;
        for (int r=j+2;r<=m-1;++r){
            if(prefix[m-r]==true){
                return r;
            }
        }
        return m;
    }
}
