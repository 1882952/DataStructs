package 二零年五月;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* ! 用户分组
* 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，每位用户都 恰好 属于某一用户组。给你一个长度为 n 的数组 groupSizes，
* 其中包含每位用户所处的用户组的大小，请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。

你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。

示例 1：
输入：groupSizes = [3,3,3,3,3,1,3]
输出：[[5],[0,1,2],[3,4,6]]
解释：
其他可能的解决方案有 [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
示例 2：
输入：groupSizes = [2,1,3,3,3,2]
输出：[[1],[0,5],[2,3,4]]
*
 思路：利用贪心算法实现分组问题，先解决一部分满的，然后再解决剩下的

* 具体使用的是hashmap实现 key为组长度，value为组中成员id
* 把题意理解为一群人在过河，号码牌为N的人上号码牌为N的船，号码牌为N的船可以容纳N个人。
方法一：
map中的key代表号码N，value代表已经在船上的人。如果人数等同于号码，就拉到返回的list里。

* * */
public class LeetCode1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        List<List<Integer>> result=new ArrayList<>(); //各组成员id总集合（需要返回的）
        for (int i = 0; i <groupSizes.length ; i++) {
            if(map.containsKey(groupSizes[i])){ //map包含这个组
                List<Integer> list=map.get(groupSizes[i]);
                list.add(i);
                if(list.size()==groupSizes[i]){
                    result.add(list);
                    map.remove(groupSizes[i]); //该组成员满了就移除
                }
            }else { //map不包含这个组
                List<Integer> list1=new ArrayList<>();
                list1.add(i);
                if(list1.size()==groupSizes[i]){ //如果list1的大小等于组值，那么就直接添加到result就行，例子 ： 下标为1 值为 1
                    result.add(list1);
                }else {
                    map.put(groupSizes[i],list1); //再map中生成该组
                }
            }

        }
        return result;
    }
}
