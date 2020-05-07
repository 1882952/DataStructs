package 二零年五月;

import java.util.*;

/*
* 前k个高频单词
* 给一非空的单词列表，返回前 k 个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
示例 1：
输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。
思路；将单词保存到map中，key为单词，value为该单词出现的次数。
然后添加到一个大小为k的优先队列中(使用小顶堆)
* */
public class LeetCode692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> count=new HashMap<>();
        for (String word: words) {
            count.put(word,count.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> heap=new PriorityQueue<String>((w1,w2)->
            count.get(w1).equals(count.get(w2)) ? w2.compareTo(w1):count.get(w1)-count.get(w2)
        );
        for (String word : count.keySet()){
            heap.offer(word);
            if(heap.size()>k){
                heap.poll();
            }
        }
        List<String> ans=new ArrayList<>();
        while (!heap.isEmpty()){
            ans.add(heap.poll());
        }
        //因为是小顶堆弹出数据，所以要反转一下
        Collections.reverse(ans);
        return ans;
    }
}
