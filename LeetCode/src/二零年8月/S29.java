package 二零年8月;

/*
* 顺时针打印矩阵
* 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
    思路 ：按照右--下---左---上---右的优先级规律
    * 所以利用i，j变量判断边界， 把矩阵的四个边界定义出来，l，r，t，b。
    *
    * 循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
            根据边界打印，即将元素按顺序添加至列表 res 尾部；
            边界向内收缩 11 （代表已被打印）；
            判断是否打印完毕（边界是否相遇），若打印完毕则跳出。

*
打印方向	1. 根据边界打印	2. 边界向内收缩	3. 是否打印完毕
从左向右	左边界l ，右边界 r	上边界 t 加 1	是否 t > b
从上向下	上边界 t ，下边界b	右边界 r 减 1	是否 l > r
从右向左	右边界 r ，左边界l	下边界 b 减 1	是否 t > b
从下向上	下边界 b ，上边界t	左边界 l 加 1	是否 l > r

* */
public class S29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1,x=0;
        int []res=new int[(r+1)*(b+1)];

        while (true){
            //从左到右
            for (int i=l;i<=r;i++) res[x++]=matrix[t][i];
            if(++t>b){
                break;
            }
            //从上到下
            for (int i = t; i <=b ; i++) res[x++]=matrix[i][r];
            if(l>--r){
                break;
            }
            //从右向左
            for (int i = r; i >=l ; i--) {
                res[x++]=matrix[b][i];
            }
            if(t>--b){
                break;
            }
            //从下到上
            for (int i = b; i >=t ; i--) {
                res[x++]=matrix[i][l];
            }
            if(++l>r){
                break;
            }
        }
        return res;
    }
}
