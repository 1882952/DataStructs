/*
* 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

思路：以下数组不可能有下一个排列： {9,5,4,3,1}
需要从右边找出一对连续的数字a【i】和a[i-1]，它们满足a[i]>a[i-1],。现在，没有对 a[i−1]
右侧的重新排列可以创建更大的排列，因为该子数组由数字按降序组成。因此，我们需要重新排列a[i−1] 右边的数字，
包括它自己。
现在，什么样子的重新排列将产生下一个更大的数字呢？我们想要创建比当前更大的排列。
因此，我们需要将数字 a[i-1]替换为位于其右侧区域的数字中比它更大的数字，例如 a[j]。

* */
public class L_31 {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while (i>=0 && nums[i+1]<=nums[i]){ //如同a[i]<=a[i-1]的情况，降序，不存在更大的值,递归往前找
            i--;
        }
        if(i>=0){  //如果找到了a[i]>a[i-1]的数，将此数又和该数组从末位重新比较替换
            int j=nums.length-1;
            while (j>=0 && nums[j]<=nums[i]){  //为了找到比num【i】大的数
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    //替换
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
