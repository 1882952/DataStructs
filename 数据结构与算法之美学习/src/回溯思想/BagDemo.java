package src.回溯思想;
/*
* 0-1 背包问题
*
* 背包总重w kg， 有n个物品，各个物品重量不同且不可分割，所以得使用回溯而不建议使用贪心。
* 对于每个物品来说，都有两种选择，装进背包或者不装进背包。对于 n 个物品来说，总的装法就有 2^n 种，去掉总重量超过 Wkg 的，
* 从剩下的装法中选择总重量最接近 Wkg 的。具体过程就是先处理一个，然后递归地装入其余的。
*
* */
public class BagDemo {
    public int maxW=Integer.MIN_VALUE; //实时的最大值

    /**
     * 利用回溯求背包问题
     * @param i  i表示装进哪个物品
     * @param cw cw表示当前已经装进去的物品的重量和
     * @param items 每个物品的重量
     * @param n 物品的个数
     * @param w 背包的重量
     */
    public void f(int i,int cw,int []items,int n,int w){
        if(cw==w || i==n){ // cw==w表示装满了;i==n表示已经考察完所有的物品
            if(cw>maxW){
                maxW=cw;
            }
            return;
        }
        f(i+1,cw,items,n,w);
        if(cw+items[i]<=w){ // 如果不满足这个条件，则证明已经超过可以背包承受的重量的时候，就不要再装了
            f(i+1,cw+items[i],items,n,w); //满足则继续装
        }
    }

}
