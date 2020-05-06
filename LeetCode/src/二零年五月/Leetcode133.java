package 二零年五月;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    克隆图
*给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
class Node {
    public int val;
    public List<Node> neighbors;
}
思路：深度优先搜索DFS，
    为了防止多次遍历同一个节点，避免陷入死循环，需要以某种方式跟踪已经复制的节点。
    过程：（1）从给定节点遍历图
          （2）使用map存储已被访问和复制的节点，key 是原始图中的节点，value 是克隆图中的对应节点。如果某个节点已经被访问过，
          则返回其克隆图中的对应节点。
          （3）当访问的节点不在map中，则创建它的克隆节点存储在hashmap中，注意：在进入递归之前，必须先创建克隆节点并保存在 HashMap 中。
          （4）递归调用每个节点的邻接点。每个节点递归调用的次数等于邻接点的数量，每一次调用返回其对应邻接点的克隆节点，
          最终返回这些克隆邻接点的列表，将其放入对应克隆节点的邻接表中。这样就可以克隆给定的节点和其邻接点。

* */
public class Leetcode133 {
    private Map<Node,Node> visited=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        //如果map包含该节点，那么就证明已经被复制,返回对应的克隆节点就行
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        //在递归前，先创建它的克隆节点，这样才能实现深拷贝
        Node cloneNode=new Node(node.val,new ArrayList<>());
        visited.put(node,cloneNode);
        //然后递归实现深拷贝,此处是深度优先，dfs
        for (Node neighbor: node.neighbors ) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
