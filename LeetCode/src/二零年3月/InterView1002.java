package 二零年3月;

import java.util.*;

/*
* 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。
* 变位词是指字母相同，但排列不同的字符串。
注意：本题相对原题稍作修改
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
思路：可以用ASC码来解决，变位词的ASC码之和肯定是相等的
* */
public class InterView1002 {
    //利用ASCII之和，执行成功，提交失败，先不采用，用下面的String判断来提交
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> lists=new ArrayList<>();
        Map<Integer,List<String>> map=new HashMap<>();
        if(strs==null){
            return lists;
        }
        Arrays.sort(strs);
        int sum=0;
        //这里是遍历数组，将集合保存在Map中
        for (String str : strs) {
            for (int i = 0; i <str.length() ; i++) {
                sum+=str.charAt(i);
            }
            if(!map.containsKey(sum)) { //如果map不包含这个sum，就创建新的list，并添加到map中
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sum, list);
            }else {   //直接添加到map中
                map.get(sum).add(str);
            }
            sum=0;
        }
        for (List<String> list : map.values()) {
            lists.add(list);
        }
        return lists;
     }

    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> lists=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        if(strs==null){
            return lists;
        }
        for (String str : strs) {
            //将str生成对应的数组后排序
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String s=new String(chars);
            if(!map.containsKey(s)){
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(s,list);
            }else {
                map.get(s).add(str);
            }
        }
        for (List<String> list : map.values()) {
            lists.add(list);
        }
        return lists;
    }
}
