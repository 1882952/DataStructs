package 十大常用算法.动态规划背包问题11_15;

public class KnaspackProblem {
    public static void main(String[] args) {
        int[] w={1,4,3};  //物品的重量
        int[] val={1500,3000,2000}; //物品的价值
        int m=4;  //背包的容量
        int n=val.length;  //物品的个数

        //为了记录方商品的情况，定义一个二维数组
        int[][] path=new int[n+1][m+1];

        //创建二维数组，表 ,    v[i][j]表示在前i个物品中能够装入容量为j的背包的最大价值
        int v[][]=new int[n+1][m+1];
        //初始化第一行和第一列,默认为0，此处初始化操作是为了更清晰
        for (int i = 0; i <v.length ; i++) {
            v[i][0]=0;  //将第一列设置为0
        }
        for (int i = 0; i <v[0].length ; i++) {
            v[0][i]=0;  //将第一行设置为0
        }

        //根据公式动态规划处理
        for (int i=1;i<v.length;i++){  //不处理第一行
            for (int j = 1; j <v[0].length ; j++) {  //不处理第一列
                if(w[i-1]>j){  //因为i是从1开始的，所以要-1，因为w从 w[0] 开始
                    v[i][j]=v[i-1][j];
                }else {
                    //说明：还是因为i是从1开始的，因此val[i-1],val[i]表示当前商品的价值
                   // v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    //为了记录商品的情况，所以用不了max方法，需要自己写
                    if(v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;  //把记录存放在path中
                    }else {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }

        //输出一下v
        for (int i = 0; i <v.length ; i++) {
            for (int j = 0; j <v[i].length ; j++) {
                System.out.print(v[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("===============================");
        //需要从最后一项反向遍历查找放入的商品
        int i=path.length-1; //行的最大下标
        int j=path[0].length-1; //列的最大下标
        while (i>0 && j>0){
            if(path[i][j]==1){
                System.out.println("第"+i+"个商品放入背包");
                j-=w[i-1];
            }
            i--;
        }
    }
}
