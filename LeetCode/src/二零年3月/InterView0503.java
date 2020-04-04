package 二零年3月;
/*
* 给定一个32位整数 num，你可以将一个数位从0变为1。
* 请编写一个程序，找出你能够获得的最长的一串1的长度。
示例 1：
输入: num = 1775(110111011112)
输出: 8
示例 2：
输入: num = 7(01112)
输出: 4
*
*
* 思路：一次迭代，
* 靠0的反转次数标记，   第一次0反转后继续加，记录反转的位置，当到第二次0反转后，要减去上次反转的位置
* java对32位的计算是33次，这点谨记，
*
* 定义curLen：记录当前的长度
*   preLen：记录上次反转后的长度，因为只能反转一次，所以需要减去上次的长度
*   准确的来说，还是利用了两指针
* */
public class InterView0503 {

    public int reverseBits(int num) {
        int maxLen=0,curLen=0,preLen=0,bits=32;
        while (bits-- >0){
            if((num & 1)==0){  //如果当前位为0，那么就要反转0并且记录位置（需要减去上次反转的位置）
                curLen-=preLen;
                preLen=curLen+1;   //让prelen保存记录curlen位置，用于下次判断反转
            }
            curLen++;
            maxLen=Math.max(curLen,maxLen);
            num>>=1;   //num向右移动一位，高位补0，再判断
        }
        return maxLen;


    }
}
