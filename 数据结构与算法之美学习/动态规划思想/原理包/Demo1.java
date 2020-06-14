package 动态规划思想.原理包;
/*
* 对Demo中的问题采用状态转移方程的解决。
*
* 状态转移方程为：
min_dist(i, j) = w[i][j] + min(min_dist(i, j-1), min_dist(i-1, j))
*
* 采用回朔加备忘录的方式完成
* */
public class Demo1 {
    //棋盘模拟 4*4
    private int[][] matrix = {{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private int n = 4;

    //记忆已经到达的状态，值为当前状态路径和
    private int[][] mem=new int[4][4];

    /**
     * 根据状态转移方程求最小路径
     * @param i x
     * @param j y
     * @return 返回当前状态的路径
     */
    public int minDist(int i,int j){
        if(i==0 && j==0){
            return matrix[0][0];
        }
        if(mem[i][j]>0){
            return mem[i][j];
        }
        int minLeft=Integer.MAX_VALUE;
        int minUp=Integer.MAX_VALUE;
        if(i-1>=0){
            minLeft=minDist(i-1,j);
        }
        if(j-1>=0){
            minUp=minDist(i,j-1);
        }

        int CurrentDist=matrix[i][j]+Math.min(minLeft,minUp);
        //保存
        mem[i][j]=CurrentDist;
        return CurrentDist;
    }

}
