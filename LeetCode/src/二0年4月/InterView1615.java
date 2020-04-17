package 二0年4月;

import java.util.HashMap;
import java.util.Map;

/*
* 珠玑妙算游戏（the game of master mind）的玩法如下。

计算机有4个槽，每个槽放一个球，颜色可能是红色（R）、黄色（Y）、绿色（G）或蓝色（B）。
例如，计算机可能有RGGB 4种（槽1为红色，槽2、3为绿色，槽4为蓝色）。作为用户，你试图猜出颜色组合。
打个比方，你可能会猜YRGB。要是猜对某个槽的颜色，则算一次“猜中”；要是只猜对颜色但槽位猜错了，
则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
给定一种颜色组合solution和一个猜测guess，编写一个方法，返回猜中和伪猜中的次数answer
，其中answer[0]为猜中的次数，answer[1]为伪猜中的次数。

示例：

输入： solution="RGBY",guess="GGRR"
输出： [1,1]
解释： 猜中1次，伪猜中1次。

思路：全部猜中的情况-real猜中的=伪猜中

过程：
使用了HashMap，将solution的元素保存到map中（包含元素数量）
然后判断map中是否有guess的元素，有则fake++，注意要更新元素数量
在来个for循环判断一致的数据real，最后fake - real等于伪猜对

* */
public class InterView1615 {
    public int[] masterMind(String solution, String guess) {
        Map<Character,Integer>  map=new HashMap<>();
        //先将solution加入到map中
        for (char c : solution.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int fake=0,real=0;
        for (char c: guess.toCharArray()){  //这是guess中能全部猜中的情况（只考虑是否有对应颜色的球，不考虑位置）
            if(map.containsKey(c) && map.get(c)>0){
                fake++;
                map.put(c,map.get(c)-1);
            }
        }
        //真实猜中的（需要颜色相同，位置对应）
        for (int i = 0; i <4 ; i++) {
            if(solution.charAt(i)==guess.charAt(i)) {
                real++;
            }
        }
        int [] ans={real,fake-real}; //利用公式，求出伪猜中的次数
        return ans;
    }
}
