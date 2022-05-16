package 排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 全排列实现
 * 田忌赛马的例子
 */
public class FullRangeTest {
    // 设置齐王的马跑完所需时间
    public static HashMap q_horses_time = new HashMap(){ { put("q1", 1.0); put("q2", 2.0); put("q3", 3.0); } };
    // 设置田忌的马跑完所需时间
    public static HashMap t_horses_time = new HashMap(){ { put("t1", 1.5); put("t2", 2.5); put("t3", 3.5); } };

    public static ArrayList q_horses = new ArrayList(Arrays.asList("q1", "q2", "q3"));

    /**
     *使用函数的递归（嵌套）调用，找出所有可能的马匹出战顺序
     * @param horses  目前还剩多少马没有出战，
     * @param result  result-保存当前已经出战的马匹及顺序
     */
    public static void permutate(ArrayList horses, ArrayList result) {
        if(horses.size()==0){
            System.out.println(result);
            compare(result,q_horses);
            return;
        }

        for (int i = 0; i < horses.size() ; i++) {
            // 从剩下的马中选中一匹 , 对于这种循环递归，如果不确认该怎么用原来的数组放，那么就创建一个新的去放，这样更容易能理解与写出来。
            // 从剩下的未出战马匹中，选择一匹，加入结果
            ArrayList new_result = (ArrayList)(result.clone());
            new_result.add(horses.get(i));
            // 将已选择的马匹从未出战的列表中移出
            ArrayList rest_horses = ((ArrayList)horses.clone());
            rest_horses.remove(i);
            permutate(rest_horses,new_result);
        }
    }

    /**
     * 得到的结果，与齐王的马匹对比，看看是否能赢
     */
    private static void compare(ArrayList t, ArrayList q){
        int win_count=0;
        for (int i = 0; i <q.size() ; i++) {
            System.out.println(t_horses_time.get(t.get(i)) + " " + q_horses_time.get(q.get(i)));
            if ((double)t_horses_time.get(t.get(i)) < (double)q_horses_time.get(q.get(i))){
                win_count++;
            }
            if(win_count > (t.size()/2)){
                System.out.println("天际获胜");
            }else {
                System.out.println("齐王获胜");
            }
        }
        System.out.println();
    }

}
