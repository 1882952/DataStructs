package 剑指Offer;

/**
 * 旋转数组的最小数字
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
 *
 * 思路：最简单的思路就是遍历数组，取最小值。
 * 但是因为是旋转数组，在一定程度上还是有序的，所以可以使用二分思想完成代码的编写。
 *
 */
public class S011 {
    public int minArray(int[] numbers) {
       int low =0;
       int high = numbers.length-1;
       while (low<high){
        int privot = low+(high-low)/2;
        if(numbers[privot] < numbers[high]){
            high = privot;
        }else if(numbers[privot]>numbers[high]){
            low = privot+1;
        }else {
            high-=1;
        }
       }
       return numbers[low];
    }
}
