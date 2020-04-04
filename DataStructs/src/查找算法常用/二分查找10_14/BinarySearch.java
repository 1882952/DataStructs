package 查找算法常用.二分查找10_14;

import java.util.ArrayList;
import java.util.List;

//注意：二分查找数组必须有序
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,14,25,34,44};
        int index=binarySearch(arr,0,arr.length-1,88);
        System.out.println("index："+index);
        System.out.println("---------------------------------");
        int[] arr1={1,8,10,14,25,25,34,44};
        List<Integer> list=binarySearchM(arr1,0,arr1.length-1,25);
        System.out.println("此值在数组中的下标："+list);
    }
    //只能找到一个值
    public static int binarySearch(int[]arr,int left,int right,int findVal){
        if(left>right){  //此数组不存在该值时的递归头条件
            return -1;
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(findVal>midVal){ //向右递归
           return binarySearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){ //向左递归
            return binarySearch(arr,left,mid-1,findVal);
        }
        return mid;
    }
    /*
    * 思考题：在一个数组中，有多个相同的值，返回所有该值的下标
    *
    * 思路：1：在找到mid时，不要立即返回；
    *       2：向mid索引值的左边扫描，将所有该值的下标，加入到集合中
    *       3：向mid索引值的右边扫描，将所有该值的下标，加入到集合中
    * */

    public static List<Integer> binarySearchM(int[]arr, int left, int right, int findVal){
        if(left>right){  //此数组不存在该值时的递归头条件
            return new ArrayList<>();
        }
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(findVal>midVal){ //向右递归
            return binarySearchM(arr,mid+1,right,findVal);
        }else if(findVal<midVal){
            return binarySearchM(arr,left,mid-1,findVal);
        }
        List<Integer> list=new ArrayList<>();
        int temp=mid-1;
        while (true){
            if(temp<0||arr[temp]!=findVal){
                break;
            }
            list.add(temp);
            temp--;
        }
        list.add(mid);
        temp=mid+1;
        while (true){
            if(temp>arr.length-1||arr[temp]!=findVal){
                break;
            }
            list.add(temp);
            temp++;
        }
        return list;
    }
}
