package 剑指Offer;

/**
 *
 *  数组中重复的数字
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 *  思路1：可以先给数组排序，然后循环遍历找出重复的数字。
 *  思路2：利用空间换时间，用一个容器，把相同的次数保存出来并统计次数。
 *  思路3：需要用一个时间空间复杂度最低的方法去实现。   对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。  可以把时间控制在O（n），也不用额外的空间。
 *   这道题的本质就是考验你的灵活性，看看你是否能活用数组中的元素，活用指针。  而且，划重点， 长度n, 范围0~n-1 ， 这就暗示了要拿下标做功夫，所以就和做数学题一样，分析题意，都是坑。
 */
public class S_03 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            //当nums[i]!=i 判断, 因为如果有重复的数字，那么肯定会有这种下标与当前i值不一样的情景
            while (nums[i] != i){
                if(nums[i]== nums[nums[i]]){  // 这里也是核心点，第 i 位数字 作为下标 的 那个元素，是否与当前元素重复。
                    return nums[i];
                }
                swap(nums,i,nums[i]);
            }
            //每一次循环后换回来
            swap(nums,i,nums[i]);
        }
        return -1;
    }

    private void swap(int[] nums,int m,int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
