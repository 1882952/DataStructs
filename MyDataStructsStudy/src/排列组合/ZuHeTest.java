package 排列组合;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 组合 ： 从 n个元素中 选出n个元素
 *
 * 思路： 还是利用一样的套路，数学归纳法 ， 但是有一点需要注意，那就是将排列中多余重复的组合去掉，可以画一个草图；
 *  ！！！！ 重点： 可以发现，只考虑选择当前元素之后的元素就行。
 */
public class ZuHeTest {

    /**
     * 从 teams.length中选取m个元素的全排列
     * @param teams
     * @param result
     * @param m
     */
    public static void combine(ArrayList<String> teams,ArrayList<String> result,int m){
        //当result保存了 m个元素时，就输出result
        if(result.size()==m){
            System.out.println(result);
            return;
        }

        for (int i = 0; i <teams.size() ; i++) {
            // 将当前元素加入到当前组合中
            ArrayList<String> next_result = (ArrayList<String>) (result.clone());
            next_result.add(teams.get(i));
            // 只考虑当前位置之后的队伍
            ArrayList<String> next_teams = new ArrayList<>(teams.subList(i+1,teams.size()));
            combine(next_teams,next_result,m);
        }
    }

    public static void main(String[] args) {
        ArrayList teams = new ArrayList(Arrays.asList("t1", "t2", "t3"));
        combine(teams,new ArrayList<String>(),2);
    }
}
