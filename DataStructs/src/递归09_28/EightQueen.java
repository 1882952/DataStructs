package 递归09_28;
/*
    八皇后的主旨思想是回朔法：，符合条件递归到下一层
* 八皇后问题（8*8），8个棋子 ，此处模拟的是从第一行第一列开始的所有情况
* 用一维数组arr模拟棋盘，下标i表示第i+1行（第几个棋子），arr[i]=val对应的值表示第i+1个皇后放在第i+1行第val+1列

    八皇后问题的思路是：每一层从起点开始都要尝试放，如果当前位置符合条件，那么就递归进入下一层放置。

    此代码为初学，所以比较规范点的版本可以去看InterView0812
* */
public class EightQueen {
    //定义一个max表示共有多少个皇后
    int max=8;
    int [] array=new int[max];//模拟棋盘
    int size=0; //模拟次数  ,第一行第一列开始摆，共有92种摆法
    int judgeCount=0;//判断冲突的次数

    public static void main(String[] args) {
      EightQueen e= new EightQueen();
      //n代表第几个皇后，0：第一个皇后
        e.check(0);
       // System.out.println("判断冲突的次数:  "+e.judgeCount);
    }

    //检查放置第n个皇后
    private void check(int n){
        if(n==max){ //即n=8，n从0开始，相当于第九个，前8个已经放好
            print();
            return;
        }
        //在当前行依次放入皇后，判断冲突
        //特别注意：check 是每一次递归时，都有一套for循环
        for (int i=0;i<max;){

            //这里也可以这么写，判断当前位置准确后，再去放皇后


            //先把第n个皇后放到该行的第1列，一步步判断
            array[n]=i;

           // judgeCount++;

            //判断当放置第n个皇后到i列时，是否冲突
            if(judge(n)){ //说明不冲突
                //接着放n+1个皇后
                check(n+1);  //
            }
            //如果冲突，则i++放置到第二列，第三列。。。依次类推
            i++;
        }
    }
    //查看放置第n个皇后时，就去检测该皇后是否和前面已经摆放的皇后冲突，
    private boolean judge(int n){
        for (int i = 0; i <n ; i++) {
            if(array[i]==array[n] || Math.abs(n-i)== Math.abs(array[n]-array[i])){ //斜率不为1或者负1
                //array[i]==array[n]:说明第n个皇后和前面的n-1个皇后在同一列;
                //Math.abs(n-i)==Math.abs(array[n]-array[i])：说明在同一斜线，即行之间的绝对值差等于列之间的绝对值差
                return false;
            }
        }
        return true;
    }
    private void print(){
        size++;
        System.out.print(size+":  ");
        for (int i = 0; i <array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
