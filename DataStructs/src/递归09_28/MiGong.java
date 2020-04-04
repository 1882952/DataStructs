package 递归09_28;
/*
* 迷宫回朔的分析
* */
public class MiGong {
    public static void main(String[] args) {
         //创建一个二维数组，模拟地图
        int [][]map=new int[8][7];
        //使用1表示墙，上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右全部置为1
        for (int i = 0; i <8 ; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        //设置挡板
        map[3][1]=1;
        map[3][2]=1;
        //输出
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
        //使用递归回朔找路
        setWay(map,1,1);
        //输出小球的路径
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //使用递归回朔来给小球找路
    /*
    * 说明：1：map表示地图；2：i，j表示小球的位置；3：如果小球能找到map[6][5]的位置，证明通路找到
    * 4：约定：当map[i][j]为0表示该点没有走过，当为1表示墙，2表示通路可以走；3：表示该点已经走过，但是走不通,是死点
    *  5；在走之前需要一个策略（方法）：下-》右-》上-》左，（先考虑向下，走不通考虑向右，然后依次）
    *  优先级依次降低，如果该点走不通，再回朔
     *  */
    public static boolean setWay(int [][]map,int i,int j){
        if(map[6][5]==2){ //通路已经找到
            return true;
        }else {
            if(map[i][j]==0){
                //按照策略走
                map[i][j]=2;//假定该点的策略可以走通
                if(setWay(map,i+1,j)){//向下走
                    return true;
                }else if(setWay(map,i,j+1)){//向右走
                    return true;
                }else if(setWay(map,i-1,j)){//向上走
                    return true;
                }else if(setWay(map,i,j-1)){//向左走
                    return true;
                }else {
                    //说明该点是走不通的，是死路
                    map[i][j]=3;
                }
            }else { //map[i][j]可能是1,2,3，即是墙，或者已经尝试走过，或者是死路点
                return false;
            }
        }
        return false;
    }
    //修改策略：改成 上-》右-》下-》左
    public static boolean setWaya(int [][]map,int i,int j){
        if(map[6][5]==2){ //通路已经找到
            return true;
        }else {
            if(map[i][j]==0){
                //按照策略走
                map[i][j]=2;//假定该点的策略可以走通
                if(setWaya(map,i-1,j)){//向上走
                    return true;
                }else if(setWaya(map,i,j+1)){//向右走
                    return true;
                }else if(setWaya(map,i+1,j)){//向下走
                    return true;
                }else if(setWaya(map,i,j-1)){//向左走
                    return true;
                }else {
                    //说明该点是走不通的，是死路
                    map[i][j]=3;
                }
            }else { //map[i][j]可能是1,2,3，即是墙，或者已经尝试走过，或者是死路点
                return false;
            }
        }
        return false;
    }
}
