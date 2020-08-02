package 二零年8月;
/*
    机器人的运动范围
*   地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格
* （不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
* 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

    思路：可以使用深度优先或者广度优先解决，但是需要判断题中给的不能进入大于k的格子
    还需要注意数位之和的计算方式 和 搜索方向代码的简化思路。 因为只从（0,0）开始，所以只考虑向下或者向右开始，使用dfs解决问题

* */
public class S13 {
    private int m,n,k;
    private boolean [][] visited;

    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        this.k=k;
        this.visited=new boolean[m][n];
        return dfs(0,0);
    }

    private int dfs(int i,int j){
        if(i>=m || j>=n || visited[i][j] || caculate(i,j)>k){
            return 0;
        }
        visited[i][j]=true;
        return 1+dfs(i+1,j)+dfs(i,j+1);
    }
    //求当前坐标的数位之和
    private int caculate(int x,int y){
        int sum=0;
        while (x!=0){
            sum+=x%10;
            x=x/10;
        }
        while (y!=0){
            sum+=y%10;
            y=y/10;
        }
        return sum;
    }
}
