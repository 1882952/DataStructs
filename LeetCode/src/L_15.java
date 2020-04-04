import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

思路：
我们采用分治的思想. 想要找出三个数相加等于0，我们可以数组依次遍历， 每一项a[i]我们都认为它是最终能够用组成0中的一个数字，那么我们的目标就是找到 剩下的元素（除a[i]）两个相加等于-a[i].
通过上面的思路，我们的问题转化为了给定一个数组，找出其中两个相加等于给定值， 这个问题是比较简单的， 我们只需要对数组进行排序，然后双指针解决即可。 加上我们需要外层遍历依次数组，因此总的时间复杂度应该是O(N^2)。
* */
public class L_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        //对数组进行排序（从小到大）
        Arrays.sort(nums);
        for (int k=0;k<nums.length-2;k++){
            if(nums[k]>0){  //因为数组是经过排序的，nums[j]>=nums[i]>=nums[k],所以三者相加肯定大于0
                break;
            }
            if (k>0 && nums[k-1]==nums[k]){  //排除当前元素是和上一个元素值相同的情况，跳过
                continue;
            }
            //利用双指针，判断nums[i]+nums[j]==nums[k]的情况
            int i=k+1,j=nums.length-1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]); //此while条件是为了防止重复,  不要用i++;
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}

