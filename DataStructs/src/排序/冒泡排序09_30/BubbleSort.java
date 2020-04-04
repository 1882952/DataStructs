package 排序.冒泡排序09_30;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={3,9,10,-2,-1};
        boolean flag=false;  //判断有没有交换
        //外层循环数组共数组大小-1次
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-i-1 ; j++) { //内层比较每次次数逐渐减小n-i-1
                if(arr[j]>arr[j+1]){
                    flag=true;
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(!flag){ //在一趟排序中，说明一次都没有交换过，说明已经排好序了
                break;
            }else {
                flag=false;  //重置flag，因为内层循环交换一次也会变为true，所以必须每次都重置，否则无效
            }
            System.out.print("第"+(i+1)+"次排序，此时数组是：");
            print(arr);
        }
        System.out.println("---------------------------------");
        print(arr);
    }

    public static void print(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
    }


}
