package 二零年8月;


/*
    矩阵中的路径.

*请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
* 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
* 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

思路：可以使用回朔算法或者dfs， 这里使用回朔， 大致思路就是依次遍历矩阵中的某点从上下左右走，并与走过的路径对比，（即把走过的坐标用数组标记出来，递归时判断）.

* */
public class S12 {

    private char[][] boards; //矩阵引用
    private char[] words; //字符串数组
    private boolean[][] passed; //判断矩阵中的坐标是否被标记过
    private int len; // 矩阵行的长度
    public boolean exist(char[][] board, String word) {
        if(word==null || word.isEmpty() || word.equals("")){
            return false;
        }
        //如果矩阵面积小于字符串长度，返回false
        if(board.length*board[0].length < word.length()){
            return false;
        }
        this.boards=board;
        this.len=board[0].length;
        this.passed=new boolean[board.length][len];
        this.words=word.toCharArray();

        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <len ; j++) {
                if(board[i][j]==words[0]){ //从字符串第一位匹配，开始判断
                    if(hashNext(i,j,1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** 递归方法
     * 判断矩阵是否与字符串对应匹配
     * @param x 横坐标
     * @param y 纵坐标
     * @param i 字符串的第几位
     */
    private boolean hashNext(int x,int y,int i){

        passed[x][y]=true;
        if(i>=words.length){
            return true;
        }
        //然后是判断向左，右，上，下四个方向的对应的点是否与字符串的第i点匹配
        if(y+1<boards[0].length && words[i]==boards[x][y+1] && !passed[x][y+1]){ //向下
            if(i==words.length-1 || hashNext(x,y+1,i+1)){
                return true;
            }
        }
        if(x+1<boards.length && words[i]==boards[x+1][y] && !passed[x+1][y]){ //向右
            if(i==words.length-1 || hashNext(x+1,y,i+1)){
                return true;
            }
        }
        if(y>0 && words[i]==boards[x][y-1] && !passed[x][y-1]){ //向上
            if(i==words.length-1 || hashNext(x,y-1,i+1)){
                return true;
            }
        }
        if(x>0 && words[i]==boards[x-1][y] && !passed[x-1][y]){ //向右
            if(i==words.length-1 || hashNext(x-1,y,i+1)){
                return true;
            }
        }

        //一定要重置，用于于下一次递归路径的判断
        passed[x][y]=false;
        return false;
    }
}
