package 动态规划思想.原理包;
/*
* 硬币找零问题，我们在贪心算法那一节中讲过一次。我们今天来看一个新的硬币找零问题。假
* 设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。
* 如果我们要支付 w 元，求最少需要多少个硬币。比如，我们有 3 种不同的硬币，1 元、3 元、5 元，我们要支付 9 元，
* 最少需要 3 个硬币（3 个 3 元的硬币）。
*
* 因为有三种硬币，所以使用状态转移方程进行动态规划 ，通过问题可得方程为 f(n)=1 +min(f(n-1),f(n-3),f(n-5)) ,注意：这个1指的是 1个硬币，并不是面值
*
* */
public class Practice {
    private int maxV=9;
    private int [] m={1,3,5};
    private int c=Integer.MAX_VALUE;
    /**
     * 利用状态转移法解决硬币找0问题 ,count(9,0),自己想的，有问题。
     * @param v
     * @param n
     * @return
     */
    public int count(int v,int n){
        if(v<=0){
            return n;
        }
        int minOne=Integer.MAX_VALUE,minThree= Integer.MAX_VALUE,minFive=Integer.MAX_VALUE;
        if(v-1>=0){
            minOne=count(v-1,n);
        }
        if(v-3>=0){
            minThree=count(v-3,n);
        }
        if(v-5>=0){
            minFive=count(v-5,n);
        }
        n=1+Math.min(minFive,Math.min(minOne,minThree));
        return n;
    }

    /**
     * 使用动态规划状态转移表解决问题
     * 根据回朔思想，根据1,3,5 定义状态（n），然后画出递归树，可以找到有重复的子状态，所以就需要画状态转移表，可以定义一个boolean二维数组，
     * x：硬币数，y：当前状态总值，然后写代码即可
     * @param money ：
     * @return
     */
    public int minCoins(int money){
        if(money==1 || money==3 || money==5){
            return 1;
        }
        boolean[][] state=new boolean[money][money+1];
        //初始化状态表第0行的值， 第0行代表只有一个硬币
        if(money>=1){
            state[0][1]=true;
        }
        if(money>=3){
            state[0][3]=true;
        }
        if(money>=5){
            state[0][5]=true;
        }

        for (int i = 1; i <money ; i++) {
            for (int j = 1; j <=money ; j++) {
                if(state[i-1][j]){ //前一个状态存在
                    if(j+1<=money){
                        state[i][j+1]=true;
                    }
                    if(j+3<=money){
                        state[i][j+3]=true;
                    }
                    if(j+5<=money){
                        state[i][j+5]=true;
                    }

                    if(state[i][money]){ //如果当前i个硬币对应的money值为true，那么就返回i+1即可
                        return i+1;
                    }
                }
            }
        }
        return money;
    }
}
