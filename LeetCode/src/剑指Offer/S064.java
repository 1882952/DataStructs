package 剑指Offer;

/**
 * 剑指 Offer 64. 求1+2+…+n
 *  要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  思路： 所以平均计算法，递归， 迭代的方式都不可以使用了
 *      那么需要使用什么，从学习数据结构与算法开始，这种什么什么都不能用的，当然就会使用位运算了
 *       通过位运算+递归，递归头可以通过位运算去控制，那么就符合题目条件了
 *
 *      这道题本质上是检验你的位运算能力怎样，但是感觉还是太偏了
 */
public class S064 {
    int res=0;
    public int sumNums(int n) {
        // 通过位运算做递归头
        boolean x = n>1 && sumNums(n-1) >0;
        res+=n;
        return res;
    }
}
