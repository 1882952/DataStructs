package hashtable08;
/*
* 仿照hashMap实现的哈希表
* 哈希表： 重点是hash函数（可以散列均匀），装载因子， hash冲突的策略--实际中优先使用拉链法
* */
public class HashTable<K,V> {
    /**
     * 散列表默认长度
     */
    private static final int DEFAULT_INITAL_CAPACITY = 8;

    /**
     * 装载因子
     */
    private static final float LOAD_FACTOR = 0.75f;

    /**
     * 初始化散列表数组
     */
    private Entry<K, V>[] table;
    /**
     * 实际元素数量
     */
    private int size = 0;

    /**
     * 散列表索引数量
     */
    private int use = 0;

    public HashTable(){
        table=(Entry<K, V>[]) new Entry[DEFAULT_INITAL_CAPACITY];
    }

    /**
     * 新增， 先进行hash，放入散列表对应的位置中，如果发生hash冲突，使用拉链法解决
     * @param key
     * @param value
     */
    public void put(K key,V value){
        int index=hash(key);
        //散列表的对应位置未被引用，创建哨兵节点
        if(table[index]==null){
            table[index]=new Entry<>(null,null,null);
        }
        Entry<K,V> temp=table[index];
        //新增节点
        if(temp.next==null){  //如果散列表的当前位置没有数据，那么就直接添加，但是也要判断是否达到装载因子，需要扩容。
            temp.next=new Entry<>(key,value,null);
            size++;
            use++; //使用的散列槽+1
            //使用率超过装载因子，则动态扩容
            if(use>table.length*LOAD_FACTOR){
                resize();
            }
        }else {  //解决散列冲突，使用链表法
            do {
                temp=temp.next;
                if(temp.key==key){ //如果遇到了key相同的节点，则替换。
                    temp.value=value;
                }
            }while (temp.next!=null);
            Entry<K,V> tmp=table[index].next;  //创键一个引用指针，指向当前链表的尾端
            table[index].next=new Entry<>(key,value,tmp);
            size++;
        }
    }
    //获取
    public V get(K key){
        int index=hash(key);
        Entry<K,V> e=table[index];
        if(e==null || e.next==null){
            return null;
        }
        while (e.next!=null){
            e=e.next;
            if(e.key.equals(key)){
                return e.value;
            }
        }
        return null;
    }
    //删除
    public void remove(K key){
        int index=hash(key);
        Entry<K,V> e=table[index];
        if(e==null || e.next==null){
            return;
        }
        Entry pre;
        Entry<K,V> headNode=table[index];
        do {
            pre=e;
            e=e.next;
            if(e.value.equals(key)){
                pre.next=e.next;
                size--;
                if(headNode.next==null){use--;}
                return;
            }
        }while (e.next!=null);
    }

    //扩容，扩容策略，每次扩容为原大小的2倍
    private void resize(){
        Entry<K,V>[] oldTable=table;
        table=(Entry<K, V>[]) new Entry[table.length*2];
        use=0;
        //这里的扩容操作是将所有的原数组中的数据重新搬运到新数组中，并没有进行优化(即每次添加数据时从原散列表中搬运部分数据)
        for (int i = 0; i <oldTable.length ; i++) {
            if(oldTable[i]==null || oldTable[i].next==null){
                continue;
            }
            Entry<K,V> e=oldTable[i];
            while (e.next!=null){  //将每条链表上的节点重新散列
                e=e.next;
                int index=hash(e.key); //重新散列
                if(table[index]==null){ //创建哨兵节点
                    use++;
                    table[index]=new Entry<>(null,null,null);
                }
                table[index].next=new Entry<>(e.key,e.value,table[index].next);
            }
        }
    }
    /**
     * 散列函数
     * 参考hashmap的散列函数，通过使用key的hashcode的高16位与数组大小取余获得
     * 选取h的高十六位与h异或是因为hashcode的主要区分度在高16位
     * @param key
     * @return
     */
    private int hash(Object key){
        int h=0;
        return (key==null) ? 0:((h=key.hashCode())^(h>>>16))%table.length;
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
