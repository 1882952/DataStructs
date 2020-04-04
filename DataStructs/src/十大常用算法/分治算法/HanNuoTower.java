package 十大常用算法.分治算法;

public class HanNuoTower {
    public static void main(String[] args) {
        hannoiTower(2,'A','B','C');
    }
    //汉诺塔移动方法：使用分治
    public static void hannoiTower(int num,char a,char b,char c){
        //如果只有一个盘
        if(num==1){
            System.out.println("第1个盘 "+a+"->"+c);
        }else { //如果n>=2，总是看做两个盘 1：最下面的盘，2：上面的盘
            //1:先把最上面的盘A——B  移动的过程会使用到b
            hannoiTower(num-1,a,c,b);
            //2:把最下面的盘A--C
            System.out.println("第"+num+"个盘 从"+a+"->"+c);
            //3:把b塔中的所有的盘从B——C，移动过程中使用到a塔
            hannoiTower(num-1,b,a,c);
        }
    }
}
