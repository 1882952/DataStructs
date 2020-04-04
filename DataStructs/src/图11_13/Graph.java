package 图11_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

//利用二维数组实现图
public class Graph {
    private ArrayList<String> vertexList;  //存储顶点的集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges; //表示边的数目
    //定义boolean【】数组，记录某个节点是否被访问
    private boolean[] isVisited;
    public static void main(String[] args) {
        int n=5;
        String vertex[]={"A","B","C","D","E"};
        Graph graph=new Graph(n);
        //循环添加顶点
        for (String s : vertex) {
            graph.insertVertex(s);
        }
        //添加边 A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

     //   graph.showGrqaph();
        System.out.println("深度遍历测试：");
      //  graph.dFS();  //A-B-C-D-E
        graph.bFS();

    }

    public Graph(int n) {
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        isVisited=new boolean[n];
        numOfEdges=0;
    }
    //得到第一个邻接节点的下标w, 如果存在返回对应的下标，否则返回-1
    public int getFirstNeighor(int index){
        for (int i = 0; i <vertexList.size() ; i++) {
            if(edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighor(int v1,int v2){
        for (int i = v2+1; i <vertexList.size() ; i++) {
            if(edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }
    //对一个节点深度优先遍历（此处只能dfs一个节点 i）
    public void dFS(boolean[] isVisited,int i){
        //1:访问该初始节点
        System.out.print(getValueByIndex(i)+"->");
        //将该访问过的节点设置为已访问
        isVisited[i]=true;
        //查找i的第一个邻接节点w
        int w=getFirstNeighor(i);
        while (w!=-1){
            if (!isVisited[w]){
                dFS(isVisited,w);
            }
            //如果w已经被访问过，则查找当前节点i的下一个邻接节点
            w=getNextNeighor(i,w);
        }
    }
    //对dfs方法进行重载（遍历所有的节点，并进行dfs）
    public void dFS(){
        //遍历所有的节点，进行DFS（类似于回朔）
        for (int i = 0; i <getNumsofVertex() ; i++) {
            if(!isVisited[i]){  //如果该节点没有被访问
                dFS(isVisited,i);
            }
        }
    }
    //对一个节点进行广度优先遍历
    private void bFS(boolean[] isVisited,int i){
        int u; //表示队列头结点对应的下标
        int w; //邻接节点w
        //队列，记录节点访问的顺序
        LinkedList queen=new LinkedList();
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i]=true;
        //加入队列
        queen.addLast(i);
        while (!queen.isEmpty()){
            //取出队列的头结点下标
            u=(Integer)queen.removeFirst();
            //得到第一个邻接结点的下标
            w=getFirstNeighor(u);
            //此处循环体现的是一层中的邻接节点
            while (w!=-1){
                //是否访问过
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"->");
                    isVisited[w]=true;
                    //入队列
                    queen.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻接点
                w=getNextNeighor(u,w);  //体现出广度优先
            }
        }
    }
    //广度优先，遍历所有的节点
    public void bFS(){
        for (int i = 0; i <getNumsofVertex(); i++) {
            if(!isVisited[i]){  //如果该节点没有被访问
                bFS(isVisited,i);
            }
        }
    }
    //图中常用方法
    //显示矩阵
    public void showGrqaph(){
        for (int[] link:edges) {
            System.out.println(Arrays.toString(link));
        }
    }
    //返回结点的个数
    public int getNumsofVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回结点i对应下标的数据
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1和v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边  v1：即第几个顶点，v2：表示第二个顶点对应的下标  例如：A——B， A就是v1，B就是V2
    public void insertEdge(int v1,int v2,int weight){
        //由于图的无向的，所以双向
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }
}
