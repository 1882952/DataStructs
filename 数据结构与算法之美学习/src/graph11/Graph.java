package graph11;

import java.util.LinkedList;
import java.util.Queue;

/*
* 无向图的bfs与dfs
* */
public class Graph {
    private int  v; //顶点的个数
    private LinkedList<Integer> adj[]; //邻接表

    public Graph(int v){
        this.v=v;
        adj=new LinkedList[v];
        for (int i = 0; i <v ; i++) {
            adj[i]=new LinkedList<>();
        }
    }
    //添加边(因为是无向图，所以要双向添加)
    public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
    }
    /*
    * 广度优先搜索图
    * 需要注意以下三点：
    *   visited 是用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点 q 被访问，那相应的 visited[q]会被设置为 true。
    *   queue 是一个队列，用来存储已经被访问、但相连的顶点还没有被访问的顶点。因为广度优先搜索是逐层访问的，
    *   prev 用来记录搜索路径。当我们从顶点 s 开始，广度优先搜索到顶点 t 后，prev 数组中存储的就是搜索的路径。不过，
    * 这个路径是反向存储的。prev[w]存储的是，顶点 w 是从哪个前驱顶点遍历过来的。比如，我们通过顶点 2 的邻接表访问到顶点 3，
    * 那 prev[3]就等于 2。为了正向打印出路径，我们需要递归地来打印，你可以看下 print() 函数的实现方式。
    * */
    public void bfs(int s,int t){
        if(s==t){
            return;
        }
        boolean []visited=new boolean[v];
        visited[s]=true; //说明顶点s被访问
        Queue<Integer> queue=new LinkedList<>();
        queue.add(s); //添加当层的顶点
        int[] prev=new int[v]; //记录顶点的搜索路径
        for (int i = 0; i <v ; i++) {
            prev[i]=-1;
        }
        while (queue.size()!=0){
            int w=queue.poll();  //添加弹出队列顶点的邻接点
            for (int i = 0; i <adj[w].size() ; i++) { //遍历w的邻接表
                int q=adj[w].get(i);
                if(!visited[q]){
                    prev[q]=w;//设置w为q的前一个顶点
                    if(q==t){  //说明已经找到t，打印就行
                        print(prev,s,t);
                        return;
                    }
                    visited[q]=true; //说明已经被访问
                    queue.add(q);
                }
            }
        }
    }
    private void print(int []prev,int s,int t){//递归打印s-->t的路径
        if(prev[t]!=-1 && s!=t){
            print(prev,s,prev[t]);
        }
        System.out.print(t+" ");
    }
    /*
    * 深度优先遍历dfs，利用了回朔思想，  深度优先一般会利用递归， 或者非递归的方式用栈
    * 全局变量found:作用是当找到终点t时，递归停止，不再查找。
    * 在代码中也利用了visited，pre
    * */
    boolean found=false;
    public void dfs(int s,int t){
        found=false;
        boolean[] visited=new boolean[v];
        int[] pre=new int[v];
        for (int i = 0; i < v; i++) {
            pre[i]=-1;
        }

        print(pre,s,t);
    }
    private void recurDfs(int w, int t, boolean[] visited, int[] prev){
        if(found==true){
            return;
        }
        visited[w]=true;//证明该顶点已经访问过了
        if(w==t){ //说明已经找到了
            found=true;
            return;
        }
        for (int i = 0; i <adj[w].size(); i++) { //遍历w的邻接表
            int q=adj[w].get(i);
            if(!visited[q]){//如果q顶点未访问
                prev[q]=w; //设置w为q的前一个顶点
                recurDfs(q,t,visited,prev);  //递归到该节点查找
            }
        }
    }
}
