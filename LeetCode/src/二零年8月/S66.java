package 二零年8月;

/** 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * 思路：https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
        对称遍历，可以通过题目画出一个矩阵，分为上三角部分和下三角部分，b的值是把a数组拆成了左右两部分，最后乘积得到的
    整体思路，结果集中任何一个元素 = 其左边所有元素的乘积 * 其右边所有元素的乘积。一轮循环构建左边的乘积并保存在结果集中，
 二轮循环 构建右边乘积的过程，乘以左边的乘积，并将最终结果保存
    使用动态规划：
 */
public class S66 {
    public int[] constructArr(int[] a) {
        if(a==null || a.length==0){
            return a;
        }
        int len=a.length;
        int[] left=new int[len];
        int[] right=new int[len];
        //左右三角区域的边界都为0
        left[0]=right[len-1]=1;
        for (int i = 1; i <a.length ; i++) {
            left[i]=left[i-1]*a[i-1];
        }
        for (int i = len-2; i >=0 ; i--) {
            right[i]=right[i+1]*a[i+1];
        }

        int [] ans=new int[len];
        for (int i = 0; i <ans.length ; i++) {
            ans[i]=left[i]*right[i];
        }
        return ans;
    }
}
