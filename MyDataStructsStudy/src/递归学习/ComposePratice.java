package 递归学习;

import java.util.ArrayList;

/**
 * 问题， 求解四种纸币的全排列， 其和等于某个值；
 *
 *  思路： 按照递归思路，即数学归纳法， n==1 时成立， 假设n==k-1成立，则 n==k 成立
 *
 *        关键点，不停地减，直到总金额等于0 或者 小于0 返回。
 */
public class ComposePratice {
    public static long[] rewards = {1, 2, 5, 10}; // 四种面额的纸币

    /** * @Description: 使用函数的递归（嵌套）调用，找出所有可能的奖赏组合 * @param totalReward-奖赏总金额，result-保存当前的解 * @return void */
    public static void get(long totalReward, ArrayList result) {
        // 当奖金总额为0时，证明是 n==1的情况
        if(totalReward == 0){
            System.out.println(result.toString());
            return;
        }else if(totalReward <0 ){ // 也是 n==1 的限定条件，不然栈溢出，这个没有考虑
            return;
        }else { // k种情况
            for (int i = 0; i <rewards.length ; i++) {
                result.add(rewards[i]);
                get(totalReward-rewards[i],result);
                result.remove(rewards[i]);  // 因为要回来，所以每次都要用完清空 result, 以供下一次使用
            }
        }
    }

    public static void main(String[] args) {
        get(10,new ArrayList<Long>());
    }
}
