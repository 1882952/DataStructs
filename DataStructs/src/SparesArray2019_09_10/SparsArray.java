package SparesArray2019_09_10;


/*
* 稀疏数组的实现
* 五子棋盘的存盘模拟
* */
public class SparsArray {
    public static void main(String[] args) {

        //创建一个原始的二维数组 11*11
        //0:表示无子 1：表示白子 2：表示黑子
        int chessArray[][]=new int[11][11];
        chessArray[1][2]=1;
        chessArray[2][3]=2;
        chessArray[5][6]=1;
        for (int[] ints : chessArray) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        //将二维数组转为稀疏数组
        //1:先遍历二维数组，得到非0数据的个数
        int sum=0;
        for (int i = 0; i <chessArray.length ; i++) {
            for (int j=0;j<chessArray[i].length;j++){
                if(chessArray[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        //创建对应的稀疏数组，数组长度加1，是因为首行要保存行数，列数，以及多少个数
        int[][] sparseArr=new int[sum+1][3];
        //给稀疏数组赋值(首行赋值),具有11行，11列，3个数据
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=2;
        //遍历二维数组值，将有效值存放到稀疏数组中
        int count=0;        //用于记录是第几个非0数据，然后自增，添加到稀疏数组中
        for (int i = 0; i <chessArray.length ; i++) {
            for (int j=0;j<chessArray[i].length;j++){
                if(chessArray[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArray[i][j];
                }
            }
        }
        //输出稀疏数组
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.print(anInt+"|  ");
            }
            System.out.println();
        }


        //将稀疏数组恢复为二维数组
        //先读取稀疏数组第一行，创建二维数组，再根据稀疏数组循环遍历赋值给二维数组
        int x=sparseArr[0][0];
        int y=sparseArr[0][1];
        int[][] newArray=new int[x][y];
        for (int i=1;i<sparseArr.length;i++){
                int xx=sparseArr[i][0];
                int yy=sparseArr[i][1];
                int value=sparseArr[i][2];
                newArray[xx][yy]=value;
        }
        //遍历新的二维数组
        for (int[] ints : newArray) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
