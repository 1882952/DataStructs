package 排序.冒泡排序09_30.希尔排序10_4;

public class ShellSort {
    public static void main(String[] args) {
        int [] arr={8,9,1,7,2,3,5,4,6,0};
        shellSortEx(arr);
        shellsort(arr);
        shellsortRe(arr);
    }

    //希尔逐步推导(使用交换法)
    public static void shellSortEx(int[] arr){
        int temp=0;
        //第一轮轮排序：将十个数据分为了10/2=5即（增量为5的）五组，（8，3），（9，5）（1，4）（7，6）（2，0）
        for (int i = 5; i <arr.length ; i++) {
            //遍历各组循环中的所有元素（共五组）  步长为：5
            for (int j = i-5; j>=0 ; j-=5) {
                if(arr[j]>arr[j+5]){  //如果前面的大于后面的
                    temp =arr[j];
                    arr[j]=arr[j+5];
                    arr[j+5]=temp;
                }
            }
        }
        System.out.println("第一轮希尔排序后："+toString(arr));
        //第二轮：将五组数据继续分为增量为5/2=2的两组
        for (int i = 2; i <arr.length ; i++) {
            //遍历各组循环中的所有元素（共两组）  步长为：2
            for (int j = i-2; j>=0 ; j-=2) {
                if(arr[j]>arr[j+2]){  //如果前面的大于后面的
                    temp =arr[j];
                    arr[j]=arr[j+2];
                    arr[j+2]=temp;
                }
            }
        }
        System.out.println("第二轮希尔排序后："+toString(arr));
        //第三轮：将两数据继续分为增量为2/2=1的一组
        for (int i = 1; i <arr.length ; i++) {
            //遍历各组循环中的所有元素  步长为：1
            for (int j = i-1; j>=0 ; j-=1) {
                if(arr[j]>arr[j+1]){  //如果前面的大于后面的
                    temp =arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("第三轮希尔排序后："+toString(arr));
    }
    //交换式的希尔排序总结
    public static void shellsort(int[] arr){
        int temp=0;
       for (int gap=arr.length/2;gap>0;gap/=2){
           //遍历各组循环中的所有元素（共gap组）  步长为：gap
           for (int i = gap; i <arr.length ; i++) {
               for (int j = i-gap; j >=0 ; j-=gap) {
                   if(arr[j]>arr[j+gap]){
                        temp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=temp;
                   }
               }
           }
       }
        System.out.println("希尔排序后："+toString(arr));
    }

    //对交换式的希尔排序进行优化-》移位法 ,即插入排序
    public static void shellsortRe(int[] arr){
        for (int gap=arr.length/2;gap>0;gap/=2){
            //从第gap个元素开始逐个对其所在的组进行直接插入
            for (int i = gap; i<arr.length; i++) {
                //直接插入排序
                int j=i;  //待插入的下标   ,注意与直接插入排序的区别，下标每次向前是减gap  ，即减去的是增量。
                int temp=arr[i]; //待插入的数
                if(arr[j-gap]>arr[j]){
                    while (j-gap>=0 && temp<arr[j-gap] ){
                        //移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
        System.out.println("希尔排序后："+toString(arr));
    }

    public static String toString(int []arr) {
        StringBuilder sb=new StringBuilder("[");
        for (int i : arr) {
            sb.append(i+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }
}
