package 一九年十二月份;
//有效的数独
/*
* 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

思路；类似于八皇后问题，比八皇后简单，直接看每一个点是否合法
* */
public class L_36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !check(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean check(char[][] board,int x,int y){
        char num=board[x][y];
        //判断同一行是否合法
        for (int i=0;i!=y && i<board.length;i++){
            if(board[x][i]==num){
                return false;
            }
        }
        //判断同一列是否合法
        for (int i = 0; i <x && i<board.length ; i++) {
            if (board[i][y]==num){
                return false;
            }
        }
        //判断九宫格是否合法
        int beginX=3*(x/3);
        int beginY=3*(y/3);
        for (int i = beginX; i <beginX+3 ; i++) {
            for (int j = beginY; j < beginY + 3; j++) {
                if (i != x && j != y && board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
