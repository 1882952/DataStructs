package 排序.冒泡排序09_30.快速排序10_12;
//快速排序的实现：以中间数为基准，通过左指针与右指针的移动  ,笔记上是以末尾数为基准的，但是原理一样，利用的是双指针
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={-9,78,0,23,23,-542,70};
        quickSort(arr,0,arr.length-1);
        System.out.println(toString(arr));
    }
    //利用双指针，左指针从头部开始向后， 有指针从末尾向前
    public static void quickSort(int[] arr,int left,int right){
        int l=left; //左下标（左指针）
        int r=right; //右下标（右指针）
        //pivot  :中轴值
        int pivot=arr[(left+right)/2];
        int temp=0; //临时变量，作为交换时使用
        //while循环的目的，比pivot小的放左边，比pivot大的放右边
        while (l<r){
            //在pivot左边一直找，找到一个大于等于pivot的值才退出
            while (arr[l]<pivot){
                l+=1;
            }
            //在pivot右边一直找，找到一个小于等于pivot的值才退出
            while (arr[r]>pivot){
                r-=1;
            }
            //如果l》=r说明pivot的左右两边的值，左边全部小于等于pivot的值，右边全部大于等于pivot的值
            if(l>=r){  //递归头  ，如果l大于r，说明两指针已经跨越了中间值，左右都比较完毕，退出
                break;
            }
            //交换
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            //如果交换完后，发现这个arr[l]==pivot值，则r前移一位，前移一位可在下一次递归比较时忽略pivot值，不然会死循环，因为r作为下层左递归的右边界
            if(arr[l]==pivot){
                r-=1;
            }
            //如果交换完后，发现这个arr[r]==pivot值，则l后移一位 ，同理，l作为下一次右递归的左边界，也需要忽略pivort值
            if(arr[r]==pivot){
                l+=1;
            }
        }
        //如果l==r，必须l++，r--，否则会出现栈溢出  ，两指针不能重合，否则会出现异常
        if(l==r){
            l+=1;
            r-=1;
        }
        //向左递归
        if(left<r){
            quickSort(arr,left,r);
        }
        //向右递归
        if(right>l){
            quickSort(arr,l,right);
        }
    }

    public static String toString(int[] arr) {
        StringBuilder s=new StringBuilder("{");
        for (int i : arr) {
            s.append(i+",");
        }
        s.setCharAt(s.length()-1,'}');
        return s.toString();
    }
}
