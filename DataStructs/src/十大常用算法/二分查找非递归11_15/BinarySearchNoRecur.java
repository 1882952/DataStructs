package 十大常用算法.二分查找非递归11_15;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr={1,8,10,14,25,34,44};
        int x=binarySearch(arr,10);
        System.out.println(x);
    }
    //二分查找的非递归实现  arr是升序数组
    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                right=mid-1; //需要向左边查找
            }else {
                left=mid+1;  //需要向右边查找
            }
        }
        return -1;
    }
}
