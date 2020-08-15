package 二零年8月;

/**礼物的最大价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，
 *
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 思路：明显的是动态规划问题，定义一个二维数组dp[][] ,保存棋盘上每个点的礼物总价值
 *  动态规划方程为 ： 如果当前点上方的礼物总价值大于左边的礼物总价值， dp[i][j]=dp[i-1][j]+grid[i][j]
 *                  如果当前点左边的礼物总价值大于上方的礼物总价值，dp[i][j]=dp[i][j-1]+grid[i][j]
 *  再初始化dp的第一行与第一列即可
 *
 */
public class S47 {

    public int maxValue(int[][] grid) {
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        //初始化dp的第0行与第0列
        int sum=0;
        for (int i=0;i<grid[0].length;i++){ //初始化第0行
            sum+=grid[0][i];
            dp[0][i]=sum;
        }
        sum=0;
        for (int i = 0; i <grid.length ; i++) { //初始化第0列
            sum+=grid[i][0];
            dp[i][0]=sum;
        }

        for (int i = 1; i <grid.length ; i++) {
            for (int j = 1; j <grid[0].length ; j++) {
                if(dp[i-1][j]>=dp[i][j-1]){// 当前点上边的大于右边的
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }else {
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
            }
        }
        return dp[grid.length][grid[0].length];
    }

    //上述代码总结的规律还可以再简化，不用初始化，代码如下：
    public int value(int[][] nums){
        int row=nums.length;
        int column=nums[0].length;
        //dp[i][j]nums[0][0]nums[i - 1][j - 1]时的最大价值 ,多开一行空间有利于判断边界问题
        int [][] dp=new int[row+1][column+1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + nums[i - 1][j - 1];
            }
        }
        return dp[row][column];
    }
}
