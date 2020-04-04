package 排序.冒泡排序09_30.插入排序10_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr={101,34,119,1};
        insertSort(arr);
        System.out.println("----------------------");
        int[] arrs=new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arrs[i]=(int)(Math.random()*80000000);
        }
        System.out.println("排序前");
        Date date1=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String dateStr=simpleDateFormat.format(date1);
        System.out.println("排序前的时间是："+dateStr);

        insertSortExample(arrs);

        Date date2=new Date();
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String dateStr1=simpleDateFormat1.format(date2);
        System.out.println("排序后的时间是："+dateStr1);
}
    //插入排序
    public static void insertSort(int[] arr){
        //逐步推导的方式
        //第一轮,将 34 插入
        int insertVal=arr[1];  //定义待插入的数
        int insertIndex=1-1;      //定义待插入数的索引，即arr[1]前面这个数的下标
        //给insertVal找到插入的位置
        while (insertIndex>=0 && insertVal<arr[insertIndex]){  //1.insertIndex>=0:保证在给insertVal找到插入位置时，不越界
            //2.insertVal<arr[insertIndex]:说明待插入的数还未找到插入位置
            //将arr[insertIndex]后移
            arr[insertIndex+1]=arr[insertIndex];  //该数组变为{101,101,119,1}
            insertIndex--;  //当不为正数时，则退出
        }
        //当退出while循环时，说明插入的位置已经找到
        arr[insertIndex+1]=insertVal;


        System.out.println("第一次插入已经完成！");
        print(arr);
        System.out.println("------------------------------");

        //第二轮插入，将119插入
         insertVal=arr[2];  //定义待插入的数
         insertIndex=2-1;      //定义待插入数的索引，即arr[1]前面这个数的下标
        while (insertIndex>=0 && insertVal<arr[insertIndex]){
            arr[insertIndex+1]=arr[insertIndex];
            insertIndex--;
        }
        arr[insertIndex+1]=insertVal;

        System.out.println("第二次插入已经完成！");
        print(arr);
        System.out.println("------------------------------");

        //第三轮，将1插入
        insertVal=arr[3];
        insertIndex=3-1;
        /*
        * 此处循环的目的是：如果要插入的元素小于前面的元素，则将前面的元素后移一位
        * 比如第三轮的循环过程是：34,101,119,119----34,101,101,119-----34,34,101,119 此时index为负数，退出循环
        * */
        while (insertIndex>=0 && insertVal<arr[insertVal]){
            arr[insertIndex+1]=arr[insertIndex];
            print(arr);
            System.out.println("<><><><><><><><><><><><><><><><><><>");
            insertIndex--;
        }
        arr[insertIndex+1]=insertVal;

        System.out.println("第三次插入已经完成！");
        print(arr);
        System.out.println("------------------------------");

    }

    public static void insertSortExample(int[] arr){
        int insertVal=0;  //待插入的数
        int insertIndex=0-1; //待插入的下标，待插入数的前一位
        for (int i=1;i<arr.length;i++){ //插入n-1次
            insertVal=arr[i];
            insertIndex=i-1;
            //insertIndex>=0 :防止数组越界   insertVal<arr[insertIndex]:若待插入的数比前面的小，则将前面的数后移
            while (insertIndex>=0 && insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;  //每一次后移完，则下标减一，再与前面的数比较
            }
            //判断是否需要赋值  ，代码优化
            if((insertIndex+1)!=i){
                //当退出while循环时，说明插入的位置已经找到
                arr[insertIndex+1]=insertVal;
            }
        }
      //  print(arr);
    }

    public static void print(int[] arr){
        for (int i = 0; i <arr.length; i++) {
            System.out.print(arr[i]+"    ");
        }
        System.out.println();
    }
}
