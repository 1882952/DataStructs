package 排序.冒泡排序09_30.选择排序10_2;

public class SelelctSort {
    public static void main(String[] args) {
        int[] arr={101,34,119,1};
        selectSort(arr);
        System.out.println("------------------------");
        selectSortExample(arr);
    }
    //选择排序
    public static void selectSort(int [] arr){
        //使用逐步推导
        int minIndex=0;  //最小数的下标
        int min=arr[0];  //最小数，假设默认是arr【0】
        //第一位数的选择，第一轮
        for (int j = 0+1; j<arr.length; j++) {
            if(min>arr[j]){ //说明假定值不是最小的
                min=arr[j];
                minIndex=j;
            }
        }
        //将最小值放在首位，即交换
        arr[minIndex]=arr[0];
        arr[0]=min;
        System.out.println("第一轮后"+"-----------------------");
        print(arr);

        //第二轮
         minIndex=1;  //最小数的下标
         min=arr[1];  //最小数，假设默认是arr【1】
        for (int j = 1+1; j <arr.length ; j++) {
            if(min>arr[j]){ //说明假定值不是最小的
                min=arr[j];
                minIndex=j;
            }
        }
        //将最小值放在首位，即交换
        arr[minIndex]=arr[1];
        arr[1]=min;
        System.out.println("第二轮后"+"-----------------------");
        print(arr);

        //第三轮
        minIndex=2;  //最小数的下标
        min=arr[2];  //最小数，假设默认是arr【1】
        for (int j = 2+1; j <arr.length ; j++) {
            if(min>arr[j]){ //说明假定值不是最小的
                min=arr[j];
                minIndex=j;
            }
        }
        //将最小值放在首位，即交换
        arr[minIndex]=arr[2];
        arr[2]=min;
        System.out.println("第三轮后"+"-----------------------");
        print(arr);

        //推导完毕，准备封装
    }

    public static void selectSortExample(int[] arr){
        int min=0; //最小值
        int minIndex=0;//最小值的下标
        for (int i = 0; i <arr.length ; i++) {
            min=arr[i];
            minIndex=i;
            for (int j = i+1; j <arr.length ; j++) {
                if(min>arr[j]){ //假定不是最小值
                    min=arr[j];
                    minIndex=j;
                }
            }
            //将最小值放到i位，交换
            if(minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        print(arr);
    }

    public static void print(int[] arr){
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+"    ");
        }
    }
}
