package 剑指Offer;

/**
 *  数组中的重复数字
 *  在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
    思路： 其实通过一个set就可以找出来，但是为了避免多余的空间 ， 我们需要用数组下标做文章， 然后突然发现，如果数组下标对应的值不等于下标的值，肯定有
 */
public class S003 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            // 如果nums[i]!=i 判断，用下标替换做文章
            while (nums[i] != i){
                if(nums[i] == nums[nums[i]]){   // 这里也是核心点，第 i 位数字 作为下标 的 那个元素，是否与当前元素重复。
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
