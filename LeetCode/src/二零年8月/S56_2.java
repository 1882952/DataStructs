package 二零年8月;

/**
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

    基本思路 ： 考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 3 的倍数。
 因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。

    思路： 使用位运算，如果一个数字出现三次,那么它的二进制表示的每一位(0或者1)也出现三次。如果把所有出现三次的数字的二进制表示的每一位都分别加起来,
    那么每一位的和都能被3整除。如果某一位的和能被3整除,那么那个只出现一次的数字二进制表示中对应的那一位是0;否则就是1;
    上述思路同样适用于数组中一个数字出现一次，其他数字出现奇数次问题(如果是偶数次，直接用异或就可)。
 这种解法的时间效率是O(n)。我们需要一个长度为32的辅助数组存储二进制表示的每一位的和。由于数组的长度是固定的,因此空间效率是O(1)。
 */
public class S56_2 {
    public int singleNumber(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        int[] bitSum=new int[32];
        int res=0;
        for(int num : nums){
            int bitMask=1;
            for(int i=31;i>=0;i--){//bitSum[0]为符号位
                //这里同样可以通过num的无符号右移>>>来实现，否则带符号右移(>>)左侧会补符号位，对于负数会出错。
                //但是不推荐这样做，最好不要修改原数组nums的数据
                if((num&bitMask)!=0) bitSum[i]++;//这里判断条件也可以写为(num&bitMask)==bitMask,而不是==1
                bitMask=bitMask<<1;//左移没有无符号、带符号的区别，都是在右侧补0
            }
        }
        for(int i=0;i<32;i++){//这种做法使得本算法同样适用于负数的情况
            res=res<<1;
            res+=bitSum[i]%3;//这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;
    }
}
