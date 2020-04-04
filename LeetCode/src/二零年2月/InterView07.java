package 二零年2月;
/*
* 给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
不占用额外内存空间能否做到？

示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

* */
public class InterView07 {
    public void rotate(int[][] matrix) {
        //思路：先左右翻，再按对角线翻
        int len=matrix.length;
        //先左右翻
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len/2 ; j++) {
                int swap=matrix[i][j];
                matrix[i][j]=matrix[i][len-1-j];
                matrix[i][len-1-j]=swap;
            }
        }
        //再按照对角线翻
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len-i ; j++) {
                int swap=matrix[i][j];
                matrix[i][j]=matrix[len-1-j][len-1-i];//因为00-22,01-12,10-21，所以是len-j，len-i
                matrix[len-1-j][len-1-i]=swap;
            }
        }
    }
}
