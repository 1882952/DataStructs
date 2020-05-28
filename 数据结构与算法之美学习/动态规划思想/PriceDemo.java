package 动态规划思想;
/*
* 双十一价格问题：比如满200 ，减50 ，找出最优的策略
*
*这个时候就可以使用动态规划，与背包问题类似，但是找出需要购买的物品还需要利用二维状态表的可达关系
* 为了保证薅羊毛有意义，所以可以将总价限定到三倍之内
* */
public class PriceDemo {
    // items商品价格，n商品个数, w表示满减条件，比如200
    public static void doublelellAdvance(int []item,int n,int w){
        boolean [][] states=new boolean[n][3*w+1]; //超过三倍就失去了薅的价值
        states[0][0]=true; //第一行的数据要特殊处理
        if(item[0]<=3*w){ //第0个商品提前处理
            states[0][item[0]]=true;
        }

        for (int i=1;i<n;i++){ //动态规划
            for (int j = 0; j <=w ; j++) { //不购买第i个物品
                if(states[i-1][j]==true){
                    states[i][j]=states[i-1][j];
                }
            }
            for (int j =3*w-item[i]; j >=0 ; j--) { //购买第i个物品
                if(states[i-1][j]==true){
                    states[i][j+item[i]]=true;
                }
            }
        }

        //接下来是根据二维数组的状态关系可达性， 找出需要购买的物品
        int j=0;
        for (j=w;j<3*w+1;j++){
            if(states[n-1][j]==true){
                break;  //输出结果大于等于w的最小值
            }
        }

        if(j==3*w+1){ //说明没有可行解
            return;
        }

        for (int i = n-1; i >=1 ; i--) {// i表示二维数组中的行，j表示列
            if(j-item[i]>=0 && states[i-1][j-item[i]]==true){ //利用这种可达性关系，显示需要购买的商品
                System.out.println(item[i]+" ");
                j=j-item[i];
            }
        }// else 没有购买这个商品，j不变。

        if(j!=0){
            System.out.println(item[0]);
        }
    }
}
