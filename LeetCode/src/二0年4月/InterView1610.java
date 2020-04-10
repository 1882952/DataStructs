package 二0年4月;

import java.util.Arrays;
/*
* 给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]，
* 实现一个方法以计算生存人数最多的年份。

你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。
如果一个人在某一年的任意时期都处于生存状态，那么他们应该被纳入那一年的统计中。
例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。

如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
示例：
输入：
birth = {1900, 1901, 1950}
death = {1948, 1951, 2000}
输出： 1901

这道题要返回的是：哪一年存活的人数最多，
每个人的出生年份构成一个数组，death年份构成一个数组，
要求是，哪一年存活的人数最多， 如果多个年份的存活人数相同，就返回最小的年份

解题思路是：
先对出生和死亡的时间进行排序
然后利用双指针，当出生时间<=死亡时间时，总人口+1，否则 -1；
记录总人口最大时的序列号；
* */
public class InterView1610 {
    public int maxAliveYear(int[] birth, int[] death) {
        //对每个人的出生年份排序
        Arrays.sort(birth);
        //对每个人的死亡年份排序
        Arrays.sort(death);

        //以上排序的目的是：便于从年份从小到大的顺序来统计人口

        // i:birth指针，j：death指针； sum:统计的总人口； max：最多人口， flag：标志位，保存最大人口max的年份
        int i=0,j=0,sum=0,max=0,flag=0;
        while (i<birth.length){  //遍历所有人的出生年份
            if(birth[i]<=death[j]){ //如果出生时间<=死亡时间时，总人口+1
                sum++;
                if(max<sum){ //判断该年份的总人口是否最大，最大则保存对应年份到flag中
                    max=sum;
                    flag=i;  //保存该年份
                }
                i++;
            }else { //否则就是出生时间大于死亡时间，那么总人口-1，说明统计中的一个人已经dead
                sum--;
                j++;
            }
        }
        return birth[flag];
    }
}
