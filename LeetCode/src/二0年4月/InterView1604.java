package 二0年4月;
/*
* 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，
* 由字符" "，"X"和"O"组成，其中字符" "代表一个空位。

以下是井字游戏的规则：

    玩家轮流将字符放入空位（" "）中。
    第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
"X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
当所有位置非空时，也算为游戏结束
。
如果游戏结束，玩家不允许再放置字符。

如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，
则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。

思路：
    这道题就是要判断各种情况的执行，横向，纵向，斜向，正对角线，逆对角线的，都要判断结果。
还有游戏结束时的各种判断，原理不难，就是判断的情况都需要考虑到。

* */
public class InterView1604 {

    private char[][] board; //棋盘
    private int len;

    public String tictactoe(String[] board) {
        //先利用board数组初始化棋盘
        len=board.length;
        this.board=new char[len][len];

        for (int i = 0; i <len ; i++) {
            this.board[i]=board[i].toCharArray();
        }

        int x_co=0,o_co=0;
        //再遍历棋盘，作判断
        for (int i = 0; i <len ; i++) {
            //按照每一行统计
            for (char ch : this.board[i]) {
                if (ch == 'X')
                    ++x_co;
                else if (ch == 'O')
                    ++o_co;
            }
        }
        //没下满棋盘
        if (x_co+o_co<len*len){
            if(is_win('X')){
                return "X";
            }
            if (is_win('O')){
                return "O";
            }
            return "Pending";
        }

        //下满棋盘
        if(is_win('X')){
            return "X";
        }
        if (is_win('O')){
            return "O";
        }
        return "Draw";
    }

    //判断到了某个点，是否能赢或者结束
    public boolean is_win(char ch){
        //按横向，每一行都判断
        search_row:             //利用了goto命令，不推荐使用
        for (int i = 0; i <len; i++) {
            for (int j = 0; j <len ; j++) {
                if(board[i][j]!=ch){
                    continue search_row;  //如果不符合，就到不了下面的return语句
                }
                return true;
            }
        }
        //按纵向：
        search_col: //纵向
        for (int j = 0; j < len; ++j) {
            for (int i = 0; i < len; ++i)
                if (board[i][j] != ch)
                    continue search_col;
            return true;
        }

        boolean found=true;
        //对角线判断：
        for (int i = 0; i <len ; i++) {
            if(board[i][i]!=ch){
                found=false;
                break;
            }
        }
        if(found){
            return true;
        }

        found=true;
        //逆对角线判断
        for (int i = 0; i <len ; i++) {
            if(board[i][len-i-1]!=ch){
                found=false;
                break;
            }
        }
        return found;
    }
}


/*
* class Solution {
    private char[][] ch_board;
    private int len;

    public String tictactoe(String[] board) {
        len = board.length;
        ch_board = new char[len][len];
        for (int i = 0; i < len; ++i)
            ch_board[i] = board[i].toCharArray();

        int X_count = 0, O_count = 0;
        for (int i = 0; i < len; ++i)
            for (char ch : ch_board[i]) {
                if (ch == 'X')
                    ++X_count;
                else if (ch == 'O')
                    ++O_count;
            }
        //没下满棋盘
        if (X_count + O_count < len * len) {
            if (is_win('X'))
                return "X";
            if (is_win('O'))
                return "O";
            return "Pending";
        }
        //下满棋盘
        if (is_win('X'))
            return "X";
        if (is_win('O'))
            return "O";
        return "Draw";
    }

    private boolean is_win(char ch) {
        search_row: //横向
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j)
                if (ch_board[i][j] != ch)
                    continue search_row;
            return true;
        }
        search_col: //纵向
        for (int j = 0; j < len; ++j) {
            for (int i = 0; i < len; ++i)
                if (ch_board[i][j] != ch)
                    continue search_col;
            return true;
        }
        boolean found = true;
        //正对角线
        for (int i = 0; i < len; ++i)
            if (ch_board[i][i] != ch) {
                found = false;
                break;
            }
        if (found) return true;
        found = true;
        //逆对角线
        for (int i = 0; i < len; ++i)
            if (ch_board[i][len - i - 1] != ch) {
                found = false;
                break;
            }

        return found;
    }
}

*
* */