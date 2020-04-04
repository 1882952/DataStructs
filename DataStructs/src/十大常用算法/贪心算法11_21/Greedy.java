package 十大常用算法.贪心算法11_21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//利用贪心算法解决广播电台集合问题
public class Greedy {
    public static void main(String[] args) {
        //创建广播电台，放入到map中
       HashMap<String,HashSet<String>> broadcasts= new HashMap<>();
       HashSet<String> hashSet1=new HashSet<>();
       hashSet1.add("北京");
       hashSet1.add("上海");
       hashSet1.add("天津");
        HashSet<String> hashSet2=new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3=new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4=new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5=new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);

        //存放所有地区
        HashSet<String> allAreas=new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //创建ArrayList，存放选择的电台集合
        List<String> selects=new ArrayList<>();
        //定义一个临时的集合，在遍历的过程中，存放遍历过程的电台覆盖和当前没有覆盖地区的交集
        HashSet<String> tempSet=new HashSet<>();
        //定义一个maxKey，保存在一次遍历过程中，能够覆盖最大未覆盖地区电台的key
        //如果maxKey不为null，则会加入到selects
        String maxKey=null;
        while (allAreas.size()!=0){
            //每进行一次循环，需要
            maxKey=null;

            //遍历broadcasts，取出对应的key
            for (String key : broadcasts.keySet()){
                //每进行一次for
                tempSet.clear();
                //当前这个key能覆盖的地区
               HashSet<String> areas=broadcasts.get(key);
               tempSet.addAll(areas);
               //求出tempSet 和 Allareas的交集,交集会赋给tempSet
                tempSet.retainAll(allAreas);
                //如果当前这个集合包含的未覆盖地区的数量，比maxKey指向的集合地区还多，就需要重置maxKey
                //tempSet.size() >broadcasts.get(maxKey).size()):体现出贪婪特性，每次都选最好的
                if(tempSet.size()>0 && (maxKey==null || tempSet.size() > broadcasts.get(maxKey).size())){
                    maxKey=key;
                }
            }
            if(maxKey !=null){ //如果maxkey不为空，就应该将maxkey加入到select中
                selects.add(maxKey);
                //将maxkey指向的广播覆盖地区从Allareas清除掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        System.out.println("得到的选择是"+selects);
    }
}
