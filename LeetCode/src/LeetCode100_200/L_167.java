package LeetCode100_200;

/**
 * 双指针思想
 * 两数之和 II - 输入有序数组
 *
 * 思路： 通过题意判断，首先想到双指针思想，通过首尾两指针，就可以前后遍历，两数之和，小了i+，大了j-
 */
public class L_167 {

    public static void main(String[] args) {
        int[] numbers =new int[]{2,7,11,15};
        int target = 9;
        int[] ints = L_167.twoSum(numbers, target);
        System.out.println("["+ints[0]+","+ints[1]+"]");
    }

    public static int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        if(length<2){
            return new int[0];
        }
        int i=0;
        int j=length-1;
        int sum = Integer.MIN_VALUE;
        while (i<j){
            sum = numbers[i]+numbers[j];
            if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }else {
             break;
            }
        }
        //返回值校验
        if(i==j){
            return new int[0];
        }
        return new int[]{i+1,j+1};
    }
}
