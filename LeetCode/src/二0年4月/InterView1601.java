package 二0年4月;
/*
* 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
示例：
输入: numbers = [1,2]
输出: [2,1]

思路：  采用位运算符，异或

a ^ b ^ b = a
a ^ b ^ a = b

a ^ a = 0
0 ^ a = a
异或满足交换律 结合律 ，这样就可以交换了
* */
public class InterView1601 {
    public int[] swapNumbers(int[] numbers) {
        //相当于a ^ b
        numbers[0]= numbers[0]^numbers[1];
        //相当于a^b^b  ,得到a
        numbers[1]=numbers[0]^numbers[1];

        //相当于 a^b^a  ,最后得到b
        numbers[0]=numbers[0]^numbers[1];

        return numbers;
    }
}
