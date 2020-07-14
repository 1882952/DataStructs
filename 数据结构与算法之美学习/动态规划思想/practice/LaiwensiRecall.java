package 动态规划思想.practice;
/*  如何实现字符串的拼写纠错功能：

 首先是需要如何量化两个字符串的相似程度，这就需要相似距离

* 编辑距离：将一个字符串转化成另一个字符串，需要的最少编辑操作次数（比如增加一个字符、删除一个字符、替换一个字符）。
* 编辑距离的计算方式之一：莱文斯距离，实质是两个字符串的差异字符个数。
*
* 可以利用回朔算法求出两字符串的莱文斯距离：
    这个问题就是把一个字符串改为另一个字符串，那么就需要求出最少编辑次数，即这个问题就变成了多阶段决策最优解问题。
    回朔是一个递归处理的过程，如果a[i]与b[j]匹配，那么就需要递归考虑a[i+1]与b[j+1]，如果a[i]与 b[j]不匹配，那我们有多种处理方式可选：
    可以删除 a[i]，然后递归考察 a[i+1]和 b[j]；
    可以删除 b[j]，然后递归考察 a[i]和 b[j+1]；
    可以在 a[i]前面添加一个跟 b[j]相同的字符，然后递归考察 a[i]和 b[j+1];
    可以在 b[j]前面添加一个跟 a[i]相同的字符，然后递归考察 a[i+1]和 b[j]；
    可以将 a[i]替换成 b[j]，或者将 b[j]替换成 a[i]，然后递归考察 a[i+1]和 b[j+1]。

* */
public class LaiwensiRecall {
    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int m=6,n=6;
    private int minDist=Integer.MAX_VALUE; //存储的结果
    //调用方式lwstBT(0,0,0)
    public void lwstBT(int i,int j,int edist){ //edist：表示处理到 a[i]和 b[j]时，已经执行的编辑操作的次数。
        if(i==n || j==m){
            if(i<n){
                edist+=n-i;
            }
            if(j<m){
                edist+=m-j;
            }
            if(edist<minDist){
                minDist=edist;
            }
            return;
        }

        if(a[i]==b[j]){ //两个字符串匹配
            lwstBT(i+1,j+1,edist);
        }else { //两个字符串不匹配
            lwstBT(i+1,j,edist+1); //删除a[i]或者在b[j]前添加一个字符
            lwstBT(i,j+1,edist+1); //删除b[j]或者在a[i]前添加一个字符
            lwstBT(i+1,j+1,edist+1); //将a【i】与b【j】替换为相同的字符，然后递归下一个
        }
    }

    /*
        上述回朔解法中，有重复性子问题，所以使用动态规划解决上述问题。使用状态转移方程解决问题，
        在本问题中，状态 (i, j) 可能从 (i-1, j)，(i, j-1)，(i-1, j-1) 三个状态中的任意一个转移过来。

        如果：a[i]!=b[j]，那么：min_edist(i, j)就等于：
        min(min_edist(i-1,j)+1, min_edist(i,j-1)+1, min_edist(i-1,j-1)+1)

        如果：a[i]==b[j]，那么：min_edist(i, j)就等于：
        min(min_edist(i-1,j)+1, min_edist(i,j-1)+1，min_edist(i-1,j-1))

        其中，min表示求三数中的最小值。     根据状态转移方程画出状态转移表，然后写出代码。
    * */

    public int lwstDP(char[] a, int n, char[] b, int m) {
        int[][] minDist = new int[n][m];
        for (int j = 0; j < m; ++j) { // 初始化第0行:a[0..0]与b[0..j]的编辑距离
            if (a[0] == b[j]) minDist[0][j] = j;
            else if (j != 0) minDist[0][j] = minDist[0][j-1]+1;
            else minDist[0][j] = 1;
        }
        for (int i = 0; i < n; ++i) { // 初始化第0列:a[0..i]与b[0..0]的编辑距离
            if (a[i] == b[0]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i-1][0]+1;
            else minDist[i][0] = 1;
        }
        for (int i = 1; i < n; ++i) { // 按行填表
            for (int j = 1; j < m; ++j) {
                if (a[i] == b[j]) minDist[i][j] = min(
                        minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]);
                else minDist[i][j] = min(
                        minDist[i-1][j]+1, minDist[i][j-1]+1, minDist[i-1][j-1]+1);
            }
        }
        return minDist[n-1][m-1];
    }

    private int min(int x, int y, int z) {
        int minv = Integer.MAX_VALUE;
        if (x < minv) minv = x;
        if (y < minv) minv = y;
        if (z < minv) minv = z;
        return minv;
    }

}
