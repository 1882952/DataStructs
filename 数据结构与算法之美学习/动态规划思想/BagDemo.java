package 动态规划思想;
/*
* 0--1 背包问题，采用动态规划的思路，下一层的决策由上一层推导出来
* 利用回朔算法解决：时间复杂度一般为O(n^2) ,而利用动态规划解决：时间复杂度一般为O(n*m)
* */
public class BagDemo {
    /**
     * @param weight 物品的重量数组
     * @param n     物品的个数
     * @param w     背包可以承受的重量
     * @return      返回物品的个数
     */
    public int kmapsack(int []weight,int n,int w){
        /*用一个二维数组保存每层可以达到的不同的状态 例子 ： 比如第0个物品。重量为2，有两种策略，不放： s[0][0]=true，放入：s[0][2]=true,
        然后就是再放入第一个物品，重量为2，放与不放的选择，那么通过上一层即第0个物品的策略推导，有三种情况 ： 0和1都不放: s[1][0]=true, 0放1不放：
        s[1][2]=true， 0和1都放：s[1][4]=true ，以此类推，而这就是动态规划的核心思路 */
        boolean [][]states=new boolean[n][w+1]; //二维是物品个数，一维是目前背包中的重量
        states[0][0]=true; //第一层数据要特殊处理，可以利用哨兵节点优化

        if(weight[0]<=w){ //优化第0个物品的放入
            states[0][weight[0]]=true;
        }

        for (int i = 1; i <n ; i++) { //动态规划的状态转移
            for (int j = 0; j <=w ; j++) { //不把第i个物品放入背包
                if(states[i-1][j]==true){
                    states[i][j]=states[i-1][j];
                }
            }
            for (int j = 0; j <=w-weight[i] ; j++) { //把第i个物品放入背包
                if(states[i-1][j]==true){
                    states[i][j+weight[i]]=true;
                }
            }
        }

        for (int i=w;i>=0;--i){ //输出结果 ,倒着遍历，这样最后一个满足条件的就是放入物品数最多的
            if(states[n-1][i]==true){
                return i;
            }
        }
        return 0;
    }

    //可以看出，动态规划是一个以空间换时间的思想（二维数组的占用），这个二维数组可以被优化为一维数组,可以利用循环变量来代替物品个数
    public static int kmapsack2(int []weight,int n,int w){
        boolean [] state=new boolean[w+1];
        state[0]=true;

        if(weight[0]<=w){
            state[weight[0]]=true;
        }

        for (int i = 1; i <n ; i++) { //动态规划
            for (int j = w-weight[i]; j >=0 ; j--) { //把第i个物品放入背包
                if(state[j]==true){
                    state[j+weight[i]]=true;
                }
            }
        }

        for (int i = w; i >=0 ; i--) {
            if(state[i]==true){
                return i;
            }
        }
        return 0;
    }

    //背包问题升级，除了个数，重量，再加入价值，求装入价值最大的个数 ，使用回朔很简单，加入参数与补充判断条件即可，这里使用动态规划
    //同理利用一个二维数组，但是这里的二维数组是int型，代表每层不同状态的价值
    public static int knapsack3(int[] weight,int[] value,int n,int w){
        int[][] states=new int[n][w+1];
        for (int i = 0; i <n ; i++) { //初始化这个二维数组
            for (int j = 0; j <=w ; j++) {
                states[i][j]=-1;
            }
        }

        states[0][0]=0;
        if(weight[0]<=w){ //初始化第0个物品
            states[0][weight[0]]=value[0];
        }

        for (int i = 1; i <n ; i++) { //动态规划
            for (int j = 0; j <=w ; j++) {
                if(states[i-1][j]>=0){ //不加入第i个物品
                    states[i][j]=states[i-1][j];
                }
            }
            for (int j = w-weight[i]; j >=0 ; j--) { //加入物品i
                if(states[i-1][j]>=0){
                    int v=states[i-1][j]+value[i];
                    if(v>states[i][j+weight[i]]){
                        states[i][j+weight[i]]=v;
                    }
                }
            }
        }

        //找出最大值
        int maxValue=-1;
        for (int i = 0; i <=w ; i++) {
            if(states[n-1][i]>maxValue){
                maxValue=states[n-1][i];
            }
        }
        return maxValue;
    }
}
