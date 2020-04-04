package 十大常用算法.普利姆算法修路问题11_22;

import java.util.Arrays;

//修路问题
public class Prim {
    public static void main(String[] args) {
        char[] data=new char[]{'A','B','C','D','E','F','G'};
        int vertxs=data.length;
        int[][] weight=new int[][]{  //0；代表两点之间不连通   ,weight[0];代表A到各点的距离
                {1000,5,7,1000,1000,1000,2},
                {5,1000,1000,9,1000,1000,3},
                {7,1000,1000,1000,8,1000,1000},
                {1000,9,1000,1000,1000,4,1000},
                {1000,1000,8,1000,1000,5,4},
                {1000,1000,1000,4,5,1000,6},
                {2,3,1000,1000,4,6,1000}
        };
       MGraph graph=new MGraph(vertxs);
       MinTree minTree=new MinTree();
       minTree.createGraph(graph,vertxs,data,weight);
       minTree.showGraph(graph);

       //测试prim
        minTree.prim(graph,0); //A,G,B,E,F,D,C
    }
}
//创建最小生成树（村庄的图）
class MinTree{
    //创建图的邻接矩阵
    public void createGraph(MGraph graph,int vertxs,char[] data,int[][] weight){
        int i,j;
        for (i=0;i<vertxs;i++){
            graph.data[i]=data[i];
            for (j=0;j<vertxs;j++){
                graph.weight[i][j]=weight[i][j];
            }
        }
    }
    //显示图的邻接矩阵
    public void showGraph(MGraph graph){
        for (int[] link : graph.weight){
            System.out.println(Arrays.toString(link));
        }
    }
    //编写prim算法，得到最小生成树   v:从图的第几个顶点开始生成树
    public void prim(MGraph graph,int v){
        //表示标记顶点是否被访问过
        int[] visited=new int[graph.vertxs];
        //把当前节点标记为已经访问
        visited[v]=1;
        //用h1和h2记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        int minweight=1000;
        for (int k = 1;  k<graph.vertxs ; k++) {  //N个顶点，有N-1个边
            //普利姆算法的核心，已访问节点与未访问节点的距离比较
            for (int i = 0; i < graph.vertxs; i++) { //i表示被访问过的节点
                for (int j = 0; j <graph.vertxs ; j++) {  //j表示还未被访问过的节点
                    if(visited[i]==1 && visited[j]==0 && graph.weight[i][j]<minweight){  //核心判断
                        //graph.weight[i][j]最小，替换(作用是选出被访问的顶点和未被访问的顶点之间最短的距离)
                        minweight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }
            //找到了一条边是最小的
            System.out.println("边《"+graph.data[h1]+","+graph.data[h2]+"> 权值："+minweight);
            //将当前找到的节点标记为已经访问
            visited[h2]=1;
            //minWeight重置为最大值
            minweight=1000;
        }
    }
}
class MGraph{
    int vertxs;  //表示图的节点个数
    char[] data;  //存放节点数据
    int[][] weight; //存放边，邻接矩阵

    public MGraph(int vertxs) {
        this.vertxs = vertxs;
        data=new char[vertxs];
        weight=new int[vertxs][vertxs];
    }
}
