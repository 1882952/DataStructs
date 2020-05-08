package 二零年五月;
/*被围绕的区域：
* 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：
X X X X
X X X X
X X X X
X O X X

思路：从例子中可以看出，被包围的0不包括边界，所以先找到边界的O，进行特殊处理，然后
把剩下的O替换为X就行。但是需要考虑如下情况：
X X X X
X X 0 X
X X 0 X
X O 0 X  这时候的 O 是不做替换的。因为和边界是连通的。为了记录这种状态，我们把这种情况下的 OO 换成 # 作为占位符，
待搜索结束之后，遇到 O替换为 X（和边界不连通的 O）；遇到 #，替换回 $O(和边界连通的 O)。

那么问题就变为了如何寻找与边界连通的O。从边界出发，对图进行dfs或者bfs即可。

这里采用的是dfs的递归方式，最常用，比如二叉树的先序遍历。
* */
public class Leetcode130 {

    public void solve(char[][] board) {
        if(board==null || board.length==0){
            return;
        }
        int m=board.length;
        int n=board[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                //从边缘O开始搜索,即i或者j满足下面四个边界条件，就说明在四条边上
                boolean isEdge=i==0 || j==0 || i==m-1 || j==n-1;
                if(isEdge&& board[i][j]=='O'){  //找到边界的o,开始dfs,找与边界连通的O，并标记
                    dfs(board,i,j);
                }
            }
        }
        //最后将标记转换为O,将O替换为X，上面的思路已经解释了
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    //深度优先找到边界连通的O，并替换为#
    private void dfs(char[][]board,int i,int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='X' || board[i][j]=='#'){
            // board[i][j] == '#' 说明已经搜索过了.
            return;
        }
        board[i][j]='#';
        dfs(board,i-1,j); //上
        dfs(board,i+1,j); //下
        dfs(board,i,j-1); //左
        dfs(board,i,j+1); //右
    }
}
