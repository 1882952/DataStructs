package 二零年8月;
/*
    数组中出现次数超过一半的数字
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

思路：（1）可以使用hashmap存储字符
     （2） 数组排序后查找
      (3)设置一个计数器count，每遇到一个和当前的数字相同的数字，就让count自增，遇到一个和当前数字不一样的数字，就让count--，
      当count < 0时，就将cur设置为当前遍历的数字。因为有一个数字出现次数超过数组长度的一半，最后得到的必然是该数字。

* */
public class S39 {

    public int majorityElement(int[] nums) {
      int count=1, cur=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if(cur!=nums[i]){
                --count;
                if(count<0){  //替换数字
                    cur=nums[i];
                    count=1;
                }
            }else {
                count++;
            }
        }
        return cur;
    }
}
