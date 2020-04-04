package 二零年3月;

import java.util.Arrays;

/*
* 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
* 编写一个方法，将 B 合并入 A 并排序。
初始化 A 和 B 的元素数量分别为 m 和 n。
示例:
输入:
A = [1,2,3,0,0,0], m = 3
B = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]

思路：先把B数组copy到A中，然后再利用排序
* */
public class InterView1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        System.arraycopy(B,0,A,m,n);
        Arrays.sort(A);
    }

    //利用逆向双指针法，从尾部开始按大到小比较
    public void merge1(int[] A, int m, int[] B, int n){
        int i=m-1;
        int j=n-1;
        while (i>=0 && j>=0){  //从数组末尾开始比大小，大了就添加该元素
            if(B[j]>=A[i]){
               A[i+j+1]=B[j--];
            }else {
                A[i+j+1]=A[i--];
            }
        }
        while (j>=0){  //如果B中还有剩余，证明剩下的元素是比A中所有元素都小的，就直接添加到A的相应位置
            A[j]=A[j--];
        }
    }
}
