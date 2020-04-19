package 二0年4月;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值
* (允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除
* 最近最少使用的项目。

它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入
新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

LRU:用链表实现，已经写过的，在java中直接用LinkedHashMap就行。
LRU：最近最少使用原则，使用linkedHashMap时就直接把新添加的节点替换到原节点，超过了容量就清空相应的entry，
如果使用链表实现的话，那么就添加一个节点时，如果链表中有该节点，先删除原节点，然后将该节点插入到链表头
                    如果链表的预计空间满了，那么就删除最后一个节点，将新节点插入链表头中。
* */
public class InterView1625 {

    private LinkedHashMap<Integer,Integer> hashMap;
    private int capacity;

    public InterView1625(int capacity) {
        this.capacity=capacity;
        hashMap=new LinkedHashMap<Integer, Integer>(capacity,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()>capacity;   //size大于capacity就清空
            }
        };
    }
    public int get(int key) {
        return hashMap.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        hashMap.put(key,value);
    }
}
