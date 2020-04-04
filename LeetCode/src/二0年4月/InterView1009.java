package 二0年4月;
/*
* 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
示例:
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。

对于查找问题，一般都会想到二分查找.
下面有二分查找的实现。

    但是这道题应该是类似于二分查找的思路，比较于走路口，每个路口都有两个选择
 将矩阵元素看为matrix[x][y]变量，
    从左下角或者右上角，对角线上的数都是中位数，所以我们可以从左下角或者右上角走，
  以左下角为例，
  如果matrix[x][y]>target,那么就往上，x--;
  如果  matrix[x][y]<target,就往右，y++；

* */
public class InterView1009 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
          if(binarySearch(ints,target)){
              return true;
          }
        }
        return false;
    }
    public boolean binarySearch(int [] array,int target){
        int left=0,right=array.length-1;
        while (left<=right){
            int mid=left+((right-left)>>>1);
            if(array[mid]==target){
                return true;
            }else if(array[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return false;
    }

    //标准的解答方案，左下角开始判断
    public boolean searchMatrix1(int[][] matrix, int target){
        //x，y初始化为矩阵的左下角坐标
        int x=matrix.length-1;
        int y=0;
        while (x>=0 && x<matrix.length-1 && y>=0 && y<=matrix[0].length-1){
            if(target>matrix[x][y]){
                y++;
                continue;
            }
            if(target<matrix[x][y]){
                x--;
                continue;
            }
            if(target==matrix[x][y]){
                return true;
            }
        }
        return false;
    }
}
