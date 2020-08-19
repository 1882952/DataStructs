package 二零年8月;

import java.util.Arrays;

/**
 * 扑克牌的顺子判断：
 *
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
    思路： 不是斗地主规则，0可以看成任意数字，所以最多可以替代两位， 判断五个数字连续,最大的牌为 max ，最小的牌为 min （大小王除外），则需满足：
 max - min < 5,才能构成连续
        方法（1）： 先排序数组，然后遍历， 统计0的个数z，只要最大牌-最小牌<5就可以构成顺子，当然，如果有除了0外重复的牌，那么就直接返回false
            （2）：集合set+遍历， 思想与方法1一样
 */
public class S61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker=0; //代表大小王的个数
        for (int i = 0; i <4 ; i++) {
            if(nums[i]==0){
                joker++;  //统计大小王的数字
            }else if(nums[i]==nums[i+1]){
                return false; //如果有重复的数字，则返回false
            }
        }
        return nums[4]-nums[joker]<5; //最大牌--最小牌<5 即可满足规则
    }
}
