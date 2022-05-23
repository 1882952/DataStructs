package Dijkstra算法;

import java.util.List;
import java.util.Map;

/**
 * Dijkstra ： 求得最短距离
 *
 对于一个有向图，求得某个节点到起点的最短用时（或最短距离，其实都是一个意思）
 实现： 按笔记，先把定义的数据结构都列出来。
        分为两步， 1获得最小权重； 2、更新权重， 可以分开用两个方法去实现这个过程
 */
public class DijkstraDemo {

    /**
     *
     * @param w weight，表示二维数组，保存了任意边的权重，缩写为w，w[m,n]表示的是从节点m到节点n的有向边之权重。
     * @param min，min_weight,表示一维数组，保存了从s到任意节点的最短权重，缩写为mw。
     * @param Finish  表示已经找到最小权重的结点之集合，缩写为 F。
     * @param s
     * @return
     */
    private int smallist(int[][] w, int[] min, List<Integer> Finish, int s){
        return -1;
    }

    // 获取当前的最小权重
    public static String findGeoWithMinWeight(Map<String,Double> mw){
        double min = Double.MAX_VALUE;
        String label = "";
        for (Map.Entry<String, Double> entry : mw.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
                label = entry.getKey();
            }
        }
        return label;
    }

    // 更新权重
    public static void updateWeight(String key, Double value, Map<String, Double> result_mw) {
        if (result_mw.containsKey(key)) {
            if (value < result_mw.get(key)) {
                result_mw.put(key, value);
            }
        } else {
            result_mw.put(key, value);
        }
    }
}
