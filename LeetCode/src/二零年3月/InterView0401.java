package 二零年3月;

import java.util.*;

/*
* 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
示例1:
 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 输出：true
示例2:
 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4],
 [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 输出 true
此题想说明的是，需找出两点之间是否存在一条通路，比如0->1->2,  0,2之间就有通路，返回true

 思路：数组存放Arraylist对象来存储图即创建邻接表，最后广度遍历
* */
public class InterView0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        int first;
        //初始化邻接表操作
        ArrayList<Integer>[] G=new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            G[i]=new ArrayList<>();
        }
        //将graph中的元素存放至邻接表中
        for (int i = 0; i <graph.length ; i++) {
            //按graph关系添加   ，比如：【0,1】，即0.add(1)
            G[graph[i][0]].add(graph[i][1]);
        }
        //利用广度遍历
        Queue queue=new LinkedList();
        queue.add(start);
        //利用队列实现广度遍历，这里是重点，如果搞不清，就相当于每次把first相关的点加入队列，
        // 然后依次弹出判断，就实现了广度优先
        //同时复习深度优先，深度优先是利用栈操作，先进的后出判断，广度优先队列操作，先进的先出先判断
        while (!queue.isEmpty()){
            //每次弹出队列头判断，这样就实现了广度优先原则。
            first=(int)queue.poll();
            if (G[first].contains(target)){
                return true;
            }else {
                //将当前节点相关的点都加入到队列
                for (Object object:G[first]){
                    queue.add(object);
                }
            }
        }
        return false;
    }
}
