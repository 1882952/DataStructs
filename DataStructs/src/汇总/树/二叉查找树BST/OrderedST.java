package 汇总.树.二叉查找树BST;

import java.util.List;

public interface OrderedST<Key extends Comparable<Key>,Value> {
    int size();

    void put(Key key, Value value);

    Value get(Key key);

    Key min();

    Key max();

    int rank(Key key);

    List<Key> keys(Key l, Key h);
}
