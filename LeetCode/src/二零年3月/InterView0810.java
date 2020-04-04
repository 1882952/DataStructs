package 二零年3月;
/*
* 颜色填充。编写函数，实现许多图片编辑软件都支持的“颜色填充”功能。给定一个屏幕
* （以二维数组表示，元素为颜色值）、一个点和一个新的颜色值，
* 将新颜色值填入这个点的周围区域，直到原来的颜色值全都改变。
示例1:
 输入：
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
 输出：[[2,2,2],[2,2,0],[2,0,1]]
 解释:
在图像的正中间，(坐标(sr,sc)=(1,1)),
在路径上所有符合条件的像素点的颜色都被更改成2。
注意，右下角的像素没有更改为2，
因为它不是在上下左右四个方向上与初始点相连的像素点。
说明：
image 和 image[0] 的长度在范围 [1, 50] 内。
给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。


    这道题就描述的离谱，水平太差，无法理解，

    举个例子： 1  0  1
               1  1  1              以（1，1）为中心，则向上下左右等于1的连续点进行改值
               1  0  1
    这里改为2：
    就变为了： 2  0  2           以中心点的上下左右出发，进行DFS深度优先
               2  2  2
               2  0  2
思路：这道题考察的是深度优先DFS，
    从目标像素位置开始上色，渲染周边和目标像素初始颜色相同的像素

 算法：
    将 color 置为目标像素初始颜色。我们从目标像素位置开始上色：若像素颜色和 color 相同
  则改变像素颜色为 newColor，然后再从四个方向进行上色，重复上述过程。

    我们可以使用 dfs 函数对目标像素进行渲染。

* */
public class InterView0810 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int target=image[sr][sc];  //需要改变的颜色
        dfs(image,newColor,sr,sc,target);
        return image;
    }
    //对目标的色块进行深度渲染
    private void dfs(int [][] image,int newColor,int i,int j,int target){
        if(image[i][j]==newColor || image[i][j]!=target){  //如果当前色块等于newColor，就返回，否则无限递归
            return;         //同时遇到值不是target的点也返回
        }
        image[i][j]=newColor;  //上色
        //然后从当前点的上下左右四个方向进行上色
        if(i>0){
            dfs(image,newColor,i-1,j,target);
        }
        if(i<image.length-1){
            dfs(image,newColor,i+1,j,target);
        }
        if(j>0){
            dfs(image,newColor,i,j-1,target);
        }
        if(j<image[i].length-1){
            dfs(image,newColor,i,j+1,target);
        }
    }
}
