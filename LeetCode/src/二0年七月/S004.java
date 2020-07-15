package 二0年七月;
/*
* 二维数组中的查找
* 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
* 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*
* 思路：因为是递增的二维数组，所以可以采用沿着固定路径的方向行走，充分利用矩阵的有序性，
* 从右上角除非，超出矩形范围就停止循环，循环条件为y < matrix.length && x >= 0，然后返回false。向下走就是行坐标y++，向左走就是列坐标x--。
最多行走m+n次就会超出矩阵范围，或者找到了目标，所以时间复杂度为O(m + n)O(m+n)，空间复杂度为O(1)O(1)。
* */
public class S004 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int x=matrix[0].length-1,y=0;
        while (y<matrix.length && x>=0){
            if(matrix[y][x]<target){
                y++;
            }else if(matrix[y][x]>target){
                x--;
            }else {
                return true;
            }
        }
        return false;
    }
}
