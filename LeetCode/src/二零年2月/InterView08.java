package 二零年2月;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
*
* 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
示例 1：

输入：
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出：
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2：

输入：
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出：
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]

* */
public class InterView08 {
    public void setZeroes(int[][] matrix) {
        //思路;先遍历一下，看哪些行和哪些列需要清0，标记一下,并保存起来，然后再清行，清列
        Set<Integer> rows=new HashSet<>();
        Set<Integer> clos=new HashSet<>();
        int m=matrix.length;
        int n=matrix[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(matrix[i][j]==0){
                    rows.add(i);
                    clos.add(j);
                }
            }
        }
        //清行
        for(Integer row:rows){
            Arrays.fill(matrix[row],0);
        }

        //清列
        for (Integer clo:clos){
            for (int i = 0; i <m ; i++) {
                matrix[i][clo]=0;
            }
        }
    }
}
