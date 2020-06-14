package 动态规划思想.原理包;
/*
* 问题：棋盘上的棋子移动，从左上角移动到右下角。
* 规则是只能向右或者向下，首先采用回朔思想解决，进行递归
*
* */
public class Demo{
    private int minDist=Integer.MAX_VALUE;

    /**
     * 回朔找出棋子移动的最短路径
     * @param i x行
     * @param j y列
     * @param dist 棋盘走到当前（i，j）上位置的路径和
     * @param w  二维数组（保存每个点上的值）
     * @param n  棋盘n位置，即右下角位置
     */
    public void minDistBT(int i,int j,int dist,int[][] w,int n){
        //到达（n-1，n-1），返回
        if(i==n && j==n){
            if(dist<minDist){
                minDist=dist;
            }
            return;
        }
        if(i<n){ //当i<n时，向右递归
            minDistBT(i+1,j,dist+w[i][j],w,n);
        }
        if(j<n){ //当j<n时，向下递归
            minDistBT(i,j+1,dist+w[i][j],w,n);
        }
    }

    /*
        但是根据上述回朔代码的描述画出递归树，可以发现，容易产生重复性的子问题，即上一状态中多个分支继续走时到达同一个点，
    所以只需要选取最小的那个分支走就行了，这个时候就可以使用动态规划，由于是二维数组，所以可以状态转移表来使用。
    */

    /**
     * 采用动态规划实现棋子的移动,使用状态转移表的方式
     *
     * @param mtrax  棋盘
     * @param n  棋盘的大小
     */
    public int minDistDync(int[][] mtrax,int n){
        //定义状态转移表对象
        int [][] state=new int[n][n];
        int sum=0;
        //初始化第0行与第0列
        for (int i = 0; i<n ;  i++){
            sum += mtrax[i][0];
            state[i][0]=sum;
        }
        for (int j = 0; j <n ; j++) {
            sum+=mtrax[0][j];
            state[0][j]=sum;
        }

        //核心，通过上一个状态的最小值确定下一个状态的路径和
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <j ; j++) {
                state[i][j]=mtrax[i][j]+Math.min(state[i-1][j],state[i][j-1]);
            }
        }
        return state[n-1][n-1];
    }
}
