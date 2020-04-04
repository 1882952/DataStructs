package 二零年3月;

import java.util.ArrayList;
import java.util.List;

/*
* 八皇后问题，重点，这道题算是复习
*
* 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，
* 也不在对角线上。
* 这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
注意：本题相对原题做了扩展
示例:
 输入：4
 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]

思路：8皇后问题重点是利用回朔，从第0层开始，一步一步向下回朔，这道题与原题不同之处在于，
对角线指的是对角线与反对角线两条。但是还是可以利用绝对值差来比较反对角线，所以与原来的八皇后
问题一致。

    总结来说，就是在第n行摆第n个点，判断是否满足条件，如果满足则
    先利用一个数组保存当前行的值，然后，利用递归摆放下一个棋子（n+1），
    最后递归到第八个棋子摆放完后就将结果添加至集合返回。
        满足条件的要求是让当前的皇后与已经摆放过的每个皇后进行比较，不满足则返回true

* */
public class InterView0812 {

    public static void main(String[] args) {
        InterView0812 in=new InterView0812();
        in.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        int[] record=new int[n];
        List<List<String>> lists=new ArrayList<>();
        back(0,lists,n,record);
        return lists;
    }

    /**
     *
     * @param i :第几行
     * @param lists ；保存结果的list
     * @param n     多少个皇后
     * @param record    记录每一行的哪一个位置,同时是模拟棋盘
     */
    public void back(int i,List<List<String>> lists,int n,int[] record){
        if (i==n){ //说明递归到最后一层
            print(lists,record);
            return;
        }
        for (int j = 0; j <n;) {
            if(judge(record,i,j)){  //符合条件向下递归回朔
                record[i]=j; //符合条件的该点保存
                back(i+1,lists,n,record);
            }
            j++;  //不符合则在当前行上重试
        }
    }

    /**
     *
     * @param record  保存棋盘中每一行皇后的位置
     * @param i    前i个皇后
     * @param j    当前位置j
     * @return
     */
    public boolean judge(int[] record,int i,int j){
        //当前的位置需要对当前摆放的每一个皇后都需要进行比较
        for (int k = 0;  k<i ; k++) {
            //判断不在同一列
            //判断俩皇后的位置斜率不为1或者-1（如果斜率为1，则可构成正三角形，高度差等于宽度差）
            if(j==record[k] || Math.abs(i-k)==Math.abs(record[k]-j)){
                return false;
            }
        }
        return true;
    }
    //print方法主要用于将回朔一次得到的结果保存到list中
    public void print(List<List<String>> lists,int [] record){
        List<String> strings=new ArrayList<>();
        for (int i = 0; i <record.length ; i++) {
            StringBuilder sb=new StringBuilder();
            //加一层for循环的目的是为了拼接字符串，形成一个二维数组
            for (int j=0;j<record.length;j++){
                if(j==record[i]){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            System.out.println(sb.toString());
            strings.add(sb.toString());  //一个string要模仿一个棋盘
        }
        lists.add(strings);
    }
}
