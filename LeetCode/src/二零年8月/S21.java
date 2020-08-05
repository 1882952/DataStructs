package 二零年8月;
/*
    调整数组顺序使奇数位于偶数面前
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

    思路：使用双指针法
        双指针i，j ，指针i从左向右寻找偶数
                    指针j从右向左寻找奇数
          直到i，j找到，  i，j每找到一次就相互交换，然后i++，j--
        可以使用 num&1 操作代替num%2操作
* */
public class S21 {
    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1;
        int tmp=-1;
        while (i<j){
            while (i < j && (nums[i]&1)==1){ //直到找到一个偶数
                i++;
            }
            while (i<  j && (nums[j]&1)==0){ //直到找到一个奇数
                j--;
            }
            //交换
            tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;

        }
        return nums;
    }
}
