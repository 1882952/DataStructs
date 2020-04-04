package 二零年3月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，
* 但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
网格中的障碍物和空位置分别用 1 和 0 来表示。
返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。

思路：深度优先搜索dfs，与路径记录保存，  属于动态规划问题，用递归实现
* */
public class InterView0802 {
    private int m;  //行
    private int n;  //列
    private int[][] grid;


    private boolean dfs(int row, int col, boolean[][] visited, List<List<Integer>> pathList){
        if(row>=m || col>=n || grid[row][col]==1 || visited[row][col]){  //当前位是障碍，或者已经走过
            return false;
        }
        pathList.add(Arrays.asList(row,col));  //将当前x，y保存
        if(row==m-1 && col==n-1){  //说明已经走到终点
            return true;
        }
        visited[row][col]=true;//将这个点设置为已经走过
        //向下走或者向右走的逻辑
        if(dfs(row+1,col,visited,pathList) || dfs(row,col+1,visited,pathList)){
            return true;
        }
        //如果当前节点走过了，却没有到终点，则从list中移除,移除最后一位就行
        pathList.remove(pathList.size()-1);
        return false;
    }

    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        this.grid=obstacleGrid;
        this.m=obstacleGrid.length;   //保存行数
        this.n=obstacleGrid[0].length;  //保存列数
        List<List<Integer>> pathList=new ArrayList<>();

        dfs(0,0,new boolean[m][n],pathList);
        return pathList;
    }
}
