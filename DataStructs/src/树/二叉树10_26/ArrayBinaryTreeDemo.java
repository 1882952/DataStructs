package 树.二叉树10_26;
//顺序存储二叉树
/*
* 规则：1：只考虑完全二叉树；
*       2：第n个元素的左子节点为2*n+1
*       3: 第n个元素的右子节点为2*n+2
*       4：第n个元素的父节点为(n-1)/2
* */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrayBinaryTree tree=new ArrayBinaryTree(arr);
        tree.preOrder(0);
    }
}
class ArrayBinaryTree{
    private int[] arr;
    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //完成顺序存储二叉树的前序遍历
    public void preOrder(int index){  //index;数组的下标
        if(arr==null||arr.length==0){
            System.out.println("数组为空");
            return;
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归
        if((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
        //向右递归
        if((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }
}
