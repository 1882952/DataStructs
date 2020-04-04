/*
* 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。
示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:
nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
思路：中位数即num3数据合并后中间的数，可以想到二分法
例：index 0  1  2  3  4  5   以偶数数列考虑
            L1  R1
    num1：3  5 | 8  9        cut1：左有几个元素
                L2  R2
    num2：1  2  7 | 10 11 12  cut2：左有几个元素

    num3:1 2 3 5 7|8 9 10 11 12
    因为num3-》num1+ num2，所以只需要分割num1得到中位数就行，num2的中位数可以有(num3。length+1)/2-num1获得
    因为都是有序数组，所以L1<=R2, L2<=R1
    如果不满足L1<=R2, L2<=R1这个条件，则证明切割的不对
    继续二分：
    若L1>R2,则cut1<<（cutL，cut1-1）：cut1左移一位
    若L2>R1，则cut2>>(cut1+1,cutR)     ：cut1右移一位

    time:O(log(m+n))
* */
public class L_04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //为了节省时间，必须让nums1的长度小于nums2
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int len=nums1.length+nums2.length;
        int cut1=0;
        int cut2=0;
        int cutL=0;
        int cutR=nums1.length;
        while (cut1<=nums1.length){
           cut1=(cutR-cutL)/2+cutL;
           cut2=(len+1)/2-cut1;  //利用num2的中位数可以有num3+1/2-num1获得
            double L1=(cut1==0)?Integer.MIN_VALUE:nums1[cut1-1];
            double R1=(cut1==nums1.length)?Integer.MAX_VALUE:nums1[cut1];
            double L2=(cut2==0)?Integer.MIN_VALUE:nums2[cut2-1];
            double R2=(cut2==nums2.length)?Integer.MAX_VALUE:nums2[cut2];
            /*如果不满足L1<=R2, L2<=R1这个条件，则证明切割的不对
            若L1>R2,则cut1<<（cutL，cut1-1）：cut1左移一位,进行二分 */
           if(L1>R2){
                cutR=cut1-1;
            }else if(L2>R1){ //若L2>R1，则cut2>>(cut1+1,cutR)     ：cut1右移一位
                cutL=cut1+1;
            }else {
                if(len%2==0){  //若数列是偶数
                    L1=(L1>L2)? L1:L2;
                    R1=(R1<R2)? R1:R2;
                    return (L1+R1)/2;
                }else {   //若数列是奇数,按规律可以得出，中位数总是在L1和L2中,
                    L1=(L1>L2)? L1:L2;
                    return L1;
                }
            }
        }
        return -1;
    }
}
